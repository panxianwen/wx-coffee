package com.yu.common.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.yu.common.config.property.WeixinProperty;
import com.yu.common.util.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class WeixinService {
    @Resource
    private WeixinProperty weiXinProperty;

    /**
     * 根据code获取微信openid
     *
     * @param code
     * @return
     */
    public String getWeiXinOpenid(String code) {
        String urlStr = "https://api.weixin.qq.com/sns/jscode2session?appid=" + weiXinProperty.getAppid()
                + "&secret=" + weiXinProperty.getAppSecret()
                + "&grant_type=authorization_code&js_code=" + code;
        String html = HttpUtil.getHtml(urlStr);
        JSONObject result = JSON.parseObject(html);
        Integer errcode = result.getInteger("errcode");
        if (errcode == null || errcode.equals(0))
            return result.getString("openid");
        else {
            log.error("[获取openid失败] 回复报文:{}", html);
            return null;
        }
    }
}
