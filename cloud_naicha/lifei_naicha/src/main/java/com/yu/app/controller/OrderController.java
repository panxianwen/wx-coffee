package com.yu.app.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.yu.app.mapper.OrderMapper;
import com.yu.app.pojo.OrderInfo;
import com.yu.app.pojo.form.CreateOrderParams;
import com.yu.app.pojo.vo.HistoryOrderVO;
import com.yu.app.service.impl.OrderServiceImpl;
import com.yu.common.annotation.AccessLimiter;
import com.yu.common.annotation.NeedLogin;
import com.yu.common.constant.Const;
import com.yu.common.enums.OrderStatus;
import com.yu.common.exception.ServiceException;
import com.yu.common.service.RedisService;
import com.yu.common.service.WeixinPayService;
import com.yu.common.util.ip.IpUtil;
import com.yu.common.util.result.R;
import com.yu.common.util.session.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Api(tags = "订单服务")
@RestController
@Slf4j
@RequestMapping("/api-app/order")
public class OrderController {

    @Resource
    private OrderServiceImpl orderService;
    @Resource
    private WeixinPayService weixinPayService;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private RedisService redisService;

    @ApiModelProperty("下订单")
    @NeedLogin
    @AccessLimiter
    @PostMapping
    public R<String> createOrder(@RequestBody CreateOrderParams orderParams, HttpServletRequest request) throws ServiceException {
        return R.ok(orderService.createOrder(orderParams, SessionUtil.getCurrentWxOpenidFromRequest(request)));
    }

    @ApiOperation("微信小程序预先支付")
    @NeedLogin
    @AccessLimiter
    @PostMapping("/pay/weixin")
    public R wxPrepay(@ApiParam String orderNo, HttpServletRequest request) throws ServiceException {
        return R.ok(orderService.wxPrepay(SessionUtil.getCurrentWxOpenidFromRequest(request), orderNo, IpUtil.getIp(request)));
    }

    // TODO 小程序支付成功后马上修改订单的标志
    @ApiOperation("小程序支付成功")
    @NeedLogin
    @PutMapping("/finishWeixinPay/{orderNo}")
    public R finishWeixinPay(@PathVariable String orderNo, HttpServletRequest request) throws ServiceException {
        return R.ok(orderMapper.finishPayOrder(orderNo, OrderStatus.ENUM_on_making.value, new Date()) > 0);
    }

    /**
     * 回调，接收微信支付的消息
     */
    @ApiOperation(value = "接收支付返回的消息")
    @AccessLimiter
    @PostMapping(value = "/orderNotifyUrl")
    public String parseOrderNotifyResult(HttpServletRequest request, HttpServletResponse response) {
        try {
            String xmlResult = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            WxPayOrderNotifyResult result = weixinPayService.parseOrderNotifyResult(xmlResult);
            // {"openid":"oxci95SnSaCpN5NAvv66T4XYDVR8","isSubscribe":"N","tradeType":"JSAPI","bankType":"OTHERS","totalFee":1,"feeType":"CNY","cashFee":1,"couponList":[],"transactionId":"4200000940202104049778217209","outTradeNo":"202104124450-1001","timeEnd":"20210404211457","returnCode":"SUCCESS","resultCode":"SUCCESS","appid":"wx23ef85500824314d","mchId":"1607726716","nonceStr":"1617542091897","sign":"00BEABEFD655439A04886C6BDFCE4069","xmlString":"<xml><appid><![CDATA[wx23ef85500824314d]]></appid>\n<bank_type><![CDATA[OTHERS]]></bank_type>\n<cash_fee><![CDATA[1]]></cash_fee>\n<fee_type><![CDATA[CNY]]></fee_type>\n<is_subscribe><![CDATA[N]]></is_subscribe>\n<mch_id><![CDATA[1607726716]]></mch_id>\n<nonce_str><![CDATA[1617542091897]]></nonce_str>\n<openid><![CDATA[oxci95SnSaCpN5NAvv66T4XYDVR8]]></openid>\n<out_trade_no><![CDATA[202104124450-1001]]></out_trade_no>\n<result_code><![CDATA[SUCCESS]]></result_code>\n<return_code><![CDATA[SUCCESS]]></return_code>\n<sign><![CDATA[00BEABEFD655439A04886C6BDFCE4069]]></sign>\n<time_end><![CDATA[20210404211457]]></time_end>\n<total_fee>1</total_fee>\n<trade_type><![CDATA[JSAPI]]></trade_type>\n<transaction_id><![CDATA[4200000940202104049778217209]]></transaction_id>\n</xml>"}

            String orderNo = result.getOutTradeNo(); // 自己数据库里的订单号
            if (!"SUCCESS".equalsIgnoreCase(result.getResultCode()) || !"SUCCESS".equalsIgnoreCase(result.getReturnCode()))
                return WxPayNotifyResponse.success("订单" + orderNo + "处理失败!");

            // TODO 这里的回调会在小程序支付成功几秒后左右，插入微信交易号和支付金额
            // 官方: 自己处理订单的业务逻辑，需要判断订单是否已经支付过，否则可能会重复调用,
            int count = orderMapper.finishPayOrderByWxPayNotify(orderNo,
                    OrderStatus.ENUM_on_making.value,
                    result.getTransactionId(),
                    result.getTotalFee());
            if (count > 0) {
                return WxPayNotifyResponse.success("订单" + orderNo + "处理成功!");
            } else {
                return WxPayNotifyResponse.success("订单" + orderNo + "已经处理过了!");
            }
        } catch (Exception e) {
            log.error("微信回调结果异常,异常原因{}" + e.getMessage());
            return WxPayNotifyResponse.fail(e.getMessage());
        }
    }

    @ApiOperation("取消订单")
    @NeedLogin
    @DeleteMapping("/cancel/{orderNo}")
    public R<String> cancelOrder(@ApiParam("订单号") @PathVariable String orderNo, HttpServletRequest request) throws ServiceException, WxPayException {
        return orderService.cancelOrder(orderNo) > 0 ? R.ok("取消成功，订单已删除") : R.fail("取消失败，请联系管理员");
    }

    @ApiOperation("确认收货")
    @NeedLogin
    @PutMapping("/confirmReceive/{orderNo}")
    public R confirm(@ApiParam("订单号") @PathVariable String orderNo, HttpServletRequest request) throws ServiceException {
        return R.ok(orderService.finishedOrder(orderNo, SessionUtil.getCurrentWxOpenidFromRequest(request)));
    }

    @ApiOperation("分页获取历史订单")
    @NeedLogin
    @GetMapping("/history/page/{pageNo}/{pageSize}")
    public R<Page<HistoryOrderVO>> getHistoryOrderByPage(@PathVariable Integer pageNo,
                                                         @PathVariable Integer pageSize,
                                                         HttpServletRequest request) throws ServiceException {
        return R.ok(orderService.getHistoryOrderByPage(pageNo, pageSize, SessionUtil.getCurrentWxOpenidFromRequest(request)));
    }

    @ApiOperation("订单详情信息")
    @GetMapping("/detail/{orderNo}")
    public R<OrderInfo> getOrderDetail(@PathVariable String orderNo) throws ServiceException {
        return R.ok(orderService.getOrderDetail(orderNo));
    }

    @ApiOperation("获取正在处理的订单列表")
    @NeedLogin
    @AccessLimiter
    @GetMapping("/notCompleted")
    public R<List<OrderInfo>> getHandlingOrders(HttpServletRequest request) throws ServiceException {
        return R.ok(orderService.getHandlingOrders(SessionUtil.getCurrentWxOpenidFromRequest(request)));
    }
}
