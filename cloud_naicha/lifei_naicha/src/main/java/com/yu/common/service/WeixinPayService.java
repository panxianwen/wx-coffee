package com.yu.common.service;

import com.github.binarywang.wxpay.bean.result.WxPayRefundQueryResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.yu.common.config.property.WeixinProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class WeixinPayService extends WxPayServiceImpl {
    @Resource
    private WeixinProperty weiXinProperty;

    @Override
    public WxPayConfig getConfig() {
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(weiXinProperty.getAppid());
        wxPayConfig.setMchId(weiXinProperty.getMchId());
        wxPayConfig.setMchKey(weiXinProperty.getMchKey());
        wxPayConfig.setNotifyUrl(weiXinProperty.getNotifyUrl());
        wxPayConfig.setKeyPath(weiXinProperty.getKeyPath());
        return wxPayConfig;
    }

}
