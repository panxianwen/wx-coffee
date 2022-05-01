package com.yu.common.util.session;


import com.yu.app.pojo.User;
import com.yu.common.constant.Const;
import com.yu.common.exception.ServiceException;
import com.yu.common.service.RedisService;
import com.yu.common.service.cache.LocalCache;
import com.yu.common.util.jwt.JWTUtil;
import com.yu.common.util.spring.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static com.yu.common.constant.Const.CONST_one_month;

/**
 * session服务
 */
@Slf4j
public class SessionUtil {
    private static RedisService redisService = SpringContextUtil.getBeanByClass(RedisService.class);

    // 添加会话缓存  缓存到redis里，CONST_user_session_prefix + userId作为key
    public static void setUserSession(User user) {
        user.setToken(JWTUtil.generateTokenWithOpenid(user.getWxOpenid()));
        redisService.set(Const.CONST_user_session_prefix + user.getWxOpenid(), user.getToken(), CONST_one_month);
        LocalCache.set(Const.CONST_user_session_prefix + user.getWxOpenid(), user.getToken(), CONST_one_month);
        log.info("[添加会话缓存] {}", user);
    }

    // 当前用户的微信openid 前提是已经登录了
    public static String getCurrentWxOpenidFromRequest(HttpServletRequest request) throws ServiceException {
        String wxOpenid = request.getAttribute(Const.CONST_wx_openid).toString();
        if (wxOpenid == null)
            throw ServiceException.CONST_user_not_login;
        return wxOpenid;
    }

    // 找请求里携带的token
    public static String getToken(HttpServletRequest request) throws ServiceException {
        String token = request.getHeader(Const.CONST_token); // 从header里面找
        if (StringUtils.isEmpty(token)) // 从url后面的参数里找
            token = request.getParameter(Const.CONST_token);
        if (token == null)
            throw ServiceException.CONST_user_not_login;
        return token;
    }

}
