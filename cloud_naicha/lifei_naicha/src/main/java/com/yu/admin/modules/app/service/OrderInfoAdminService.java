package com.yu.admin.modules.app.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.yu.admin.modules.app.mapper.OrderInfoAdminMapper;
import com.yu.admin.modules.app.mapper.OrderRefundMapper;
import com.yu.admin.modules.app.pojo.OrderInfoAdmin;
import com.yu.admin.modules.app.pojo.OrderRefund;
import com.yu.common.enums.OrderStatus;
import com.yu.common.enums.OrderTakeType;
import com.yu.common.exception.ServiceException;
import com.yu.common.service.WeixinPayService;
import com.yu.common.util.GeneratorUtil;
import com.yu.common.util.weixin.WeixinUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Service
public class OrderInfoAdminService {

    @Resource
    private OrderInfoAdminMapper orderInfoAdminMapper;
    @Resource
    private WeixinPayService wxPayService;
    @Resource
    private OrderRefundMapper orderRefundMapper;

    /**
     * 分页条件查询
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return Page<OrderInfoAdmin>
     */
    public Page<OrderInfoAdmin> getOrderInfoAdminByPage(int pageNo, int pageSize, String orderStatus) {
        Page<OrderInfoAdmin> page = new Page<>(pageNo, pageSize);
        if (StringUtils.isEmpty(orderStatus)) {
            return orderInfoAdminMapper.selectPage(page, new QueryWrapper<OrderInfoAdmin>().orderByDesc("create_time"));
        } else {
            return orderInfoAdminMapper.selectPage(page, new QueryWrapper<OrderInfoAdmin>()
                    .eq("order_status", orderStatus).orderByDesc("create_time"));
        }
    }


    // 进入订单的下一个步
    @Transactional(rollbackFor = Exception.class)
    public String toNextOrderStatus(String orderNo, String currentStatus) throws ServiceException {
        OrderInfoAdmin orderInfo = orderInfoAdminMapper.selectById(orderNo);
        if (OrderStatus.ENUM_on_making.value.equalsIgnoreCase(orderInfo.getOrderStatus())) { // 制作中
            if (OrderTakeType.ENUM_take_out.value.equals(orderInfo.getTakeType())) { // 外卖配送方式
                orderInfo.setOrderStatus(OrderStatus.ENUM_on_sending.value); // 修改为配送中
            } else {
                orderInfo.setOrderStatus(OrderStatus.ENUM_please_take_meal.value); // 修改为请取餐
            }
            orderInfo.setFinishTime(new Date()); // 完成时间
            // TODO 通过公众号消息通知用户取餐
            try {
                WeixinUtil.sendMpMessageOfFinishOrder(orderInfo.getWxOpenid(), orderInfo.getOrderNo(), orderInfo.getGoodsPreview());
            } catch (Exception e) {
                log.error("通过公众号消息通知用户取餐，通知失败");
            }
        } else if (OrderStatus.ENUM_on_sending.value.equalsIgnoreCase(orderInfo.getOrderStatus())) { // 配送中
            orderInfo.setOrderStatus(OrderStatus.ENUM_has_received.value); // 修改为已送达
        } else if (OrderStatus.ENUM_please_take_meal.value.equalsIgnoreCase(orderInfo.getOrderStatus())) { // 请取餐
            orderInfo.setOrderStatus(OrderStatus.ENUM_has_received.value); // 修改为已送达
        } else if (OrderStatus.ENUM_has_received.value.equalsIgnoreCase(orderInfo.getOrderStatus())) { // 已送达
            orderInfo.setOrderStatus(OrderStatus.ENUM_has_completed.value); // 完成订单
            orderInfo.setFinishTime(new Date());
        } else {
            throw ServiceException.CONST_current_order_status_can_not_change;
        }
        orderInfoAdminMapper.updateById(orderInfo);
        return orderInfo.getOrderStatus();
    }

    public String cancelOrderNotPay(String orderNo) throws ServiceException {
        OrderInfoAdmin orderInfoAdmin = orderInfoAdminMapper.selectById(orderNo);
        if (orderInfoAdmin == null)
            throw ServiceException.CONST_order_not_exist;

        if (OrderStatus.ENUM_has_not_pay_money.value.equals(orderInfoAdmin.getOrderStatus())) {
            orderInfoAdmin.setOrderStatus(OrderStatus.ENUM_has_canceled.value);
            orderInfoAdmin.setExtraInfo("订单取消原因: [商家取消]");
            orderInfoAdminMapper.updateById(orderInfoAdmin);
            return "取消成功";
        }
        return "无法取消, 用户已完成了支付";
    }

    // 商家取消订单并执行退款
    @Transactional(rollbackFor = Exception.class)
    public String cancelAndRefund(String orderNo, String reason) throws ServiceException {
        OrderInfoAdmin orderInfoAdmin = orderInfoAdminMapper.selectById(orderNo);
        if (orderInfoAdmin == null)
            throw ServiceException.CONST_order_not_exist;

        WxPayRefundRequest refundRequest = WxPayRefundRequest.newBuilder()
                .outRefundNo(GeneratorUtil.generateRefundNo())
                .outTradeNo(orderNo)
                .refundDesc(reason)
                .totalFee(orderInfoAdmin.getPayPrice())
                .refundFee(orderInfoAdmin.getPayPrice()).build();
        try {
            WxPayRefundResult result = wxPayService.refund(refundRequest);
            orderInfoAdmin.setExtraInfo(orderInfoAdmin.getExtraInfo() + " 订单取消原因: [商家取消], " + reason);

            if (result.getReturnCode().equalsIgnoreCase("SUCCESS") && result.getResultCode().equalsIgnoreCase("SUCCESS")) {
                orderInfoAdmin.setOrderStatus(OrderStatus.ENUM_has_refunded.value);
            } else {
                orderInfoAdmin.setOrderStatus(OrderStatus.ENUM_on_refunding.value);
            }
            orderInfoAdminMapper.updateById(orderInfoAdmin);

            // 插入退款数据
            OrderRefund refund = new OrderRefund();
            refund.setRefundNo(result.getOutRefundNo());
            refund.setWxRefundId(result.getRefundId());
            refund.setWxPayTransactionId(result.getTransactionId());
            refund.setOrderNo(result.getOutTradeNo());
            refund.setCreateTime(new Date());
            refund.setStatus(OrderRefund.OrderRefundStatus.ENUM_processing.status);
            refund.setRefundFee(result.getRefundFee());
            refund.setOrderPayPrice(result.getTotalFee());
            orderRefundMapper.insert(refund);
            return result.getReturnMsg();
        } catch (WxPayException e) {
            throw new ServiceException("退款失败: " + e.getCustomErrorMsg());
        }
    }

    // TODO 主动查询微信订单的支付状态并修改, 用于定时追踪轮询订单的状态和信息
    public WxPayOrderQueryResult queryWeixinOrder(String orderNo) throws WxPayException {
        WxPayOrderQueryResult result = wxPayService.queryOrder(null, orderNo);
        String state = result.getTradeState();
        if (state.equalsIgnoreCase(WxPayConstants.WxpayTradeStatus.SUCCESS)) { // 成功
            orderInfoAdminMapper.updateOrderStatus(orderNo, result.getTransactionId(), OrderStatus.ENUM_on_making.value, result.getTotalFee());
        } else if (state.equalsIgnoreCase(WxPayConstants.WxpayTradeStatus.REFUND)) { // 退款中
            orderInfoAdminMapper.updateOrderStatus(orderNo, result.getTransactionId(), OrderStatus.ENUM_on_refunding.value, result.getTotalFee());
        } else if (state.equalsIgnoreCase(WxPayConstants.WxpayTradeStatus.NOTPAY) || state.equalsIgnoreCase(WxPayConstants.WxpayTradeStatus.PAY_ERROR)) {
            orderInfoAdminMapper.updateOrderStatus(orderNo, result.getTransactionId(), OrderStatus.ENUM_has_not_pay_money.value, result.getTotalFee());
        } else if (state.equalsIgnoreCase(WxPayConstants.WxpayTradeStatus.CLOSED)) { // 已经关闭
            orderInfoAdminMapper.updateOrderStatus(orderNo, result.getTransactionId(), OrderStatus.ENUM_has_canceled.value, result.getTotalFee());
        }
        System.out.println("主动查询微信订单的支付状态： " + state);
        return result; // 支付结果
    }

}
