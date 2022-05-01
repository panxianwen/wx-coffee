package com.yu.admin.modules.app.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.yu.admin.modules.app.mapper.OrderInfoAdminMapper;
import com.yu.admin.modules.app.mapper.OrderRefundMapper;
import com.yu.admin.modules.app.pojo.OrderInfoAdmin;
import com.yu.admin.modules.app.pojo.dto.RecentOrderMessage;
import com.yu.admin.modules.app.service.OrderInfoAdminService;
import com.yu.common.annotation.AccessLimiter;
import com.yu.common.annotation.NeedPermission;
import com.yu.common.exception.ServiceException;
import com.yu.common.service.WeixinPayService;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Api(tags = "系统：订单管理")
@RestController
@RequestMapping("/api-system/orderInfoAdmin")
public class OrderInfoAdminController {

    @Resource
    private OrderInfoAdminService orderInfoAdminService;


    @ApiOperation("分页查询")
    @NeedPermission("system:orderInfo:list")
    @GetMapping("/page")
    public R<Page<OrderInfoAdmin>> getOrderInfoAdminByPage(@RequestParam(defaultValue = "1") int pageNo,
                                                           @RequestParam(defaultValue = "10") int pageSize,
                                                           @RequestParam(required = false) String orderStatus) {
        return R.ok(orderInfoAdminService.getOrderInfoAdminByPage(pageNo, pageSize, orderStatus));
    }


    @ApiOperation("进入订单的下一个步")
    @NeedPermission("system:orderInfo:update")
    @PostMapping("/nextStatus/{orderNo}/{currentStatus}")
    public R<String> toNextOrderStatus(@PathVariable String orderNo, @PathVariable String currentStatus) throws ServiceException {
        return R.ok(orderInfoAdminService.toNextOrderStatus(orderNo, currentStatus));
    }

    /*
        promotionDetail=null,
        deviceInfo=null,
        openid=oxci95SnSaCpN5NAvv66T4XYDVR8,
        isSubscribe=N,
        tradeType=JSAPI,
        tradeState=SUCCESS,
        bankType=OTHERS,
        totalFee=1,
        settlementTotalFee=null,
        feeType=CNY,
        cashFee=1,
        cashFeeType=CNY,
        couponFee=null,
        couponCount=null,
        coupons=null,
        transactionId=4200000993202104034676739322,
        outTradeNo=202104231628-1009,
        attach=,
        timeEnd=20210403231727,
        tradeStateDesc=支付成功
       * */
    @ApiOperation("主动查询微信订单的支付状态")
//    @NeedPermission("system:orderInfo:list")
    @AccessLimiter
    @GetMapping("/wxPayStatus/{orderNo}")
    public R<String> queryWeixinOrder(@PathVariable String orderNo) throws WxPayException {
        return R.ok(orderInfoAdminService.queryWeixinOrder(orderNo).getTradeStateDesc());
    }

    @ApiOperation("商家取消没有付款的订单")
//    @NeedPermission("system:orderInfo:delete")
    @PutMapping("/cancelOrderNotPay/{orderNo}")
    public R cancelOrderNotPay(@PathVariable String orderNo) throws ServiceException {
        return R.ok(orderInfoAdminService.cancelOrderNotPay(orderNo));
    }

    @ApiOperation("商家取消订单并执行退款")
//    @NeedPermission("system:orderInfo:delete")
    @PutMapping("/cancelAndRefund/{orderNo}")
    public R cancelAndRefund(@PathVariable String orderNo, String reason) throws ServiceException {
        return R.ok(orderInfoAdminService.cancelAndRefund(orderNo, reason));
    }
}
