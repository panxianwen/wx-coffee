package com.yu.common.config.property;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 微信相关属性
@Data
@Configuration
public class WeixinProperty {
    @Value("${my.properties.wx.appid}")
    private String appid;

    @Value("${my.properties.wx.appSecret}")
    private String appSecret;

    @Value("${my.properties.wx.mchId}")
    private String mchId; // 个人商户号

    @Value("${my.properties.wx.mchKey}")
    private String mchKey;

    @Value("${my.properties.wx.notifyUrl}")
    private String notifyUrl; // 回调地址

    @Value("${my.properties.wx.keyPath}") // api3的证书地址 退款时要用到
    private String keyPath;

    // 公众号的appid
    @Value("${my.properties.wx.mpAppid}")
    private String mpAppid;

    // 公众号的订单消息模板
    @Value("${my.properties.wx.messageTemplateId}")
    private String messageTemplateId;
}
