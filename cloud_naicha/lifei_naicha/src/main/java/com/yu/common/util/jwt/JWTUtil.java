package com.yu.common.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yu.common.exception.ServiceException;
import com.yu.common.config.property.JWTProperty;
import com.yu.common.util.spring.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * jwt工具类
 */
@Slf4j
public class JWTUtil {

    private static final String jwtSecret = SpringContextUtil.getBeanByClass(JWTProperty.class).getSecret();

    // 校验 token是否正确
    public static boolean verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(jwtSecret)).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            log.error("token无效 {}", e.getMessage());
            return false;
        }
    }

    // 生成 token
    public static String generateTokenWithOpenid(String wxOpenid) {
        try {
            return JWT.create()
                    .withClaim("wxOpenid", wxOpenid)
                    .withClaim("createTime", System.currentTimeMillis()) // TODO 加入随机值让同一个用户的token不一样实现单点登录
                    .sign(Algorithm.HMAC256(jwtSecret)); // 加上服务器秘钥 也可以再加上用户密码
        } catch (Exception e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }

    // 从 token中获取用户的wxOpenid
    public static String getWxOpenid(String token) throws ServiceException {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("wxOpenid").asString();
        } catch (JWTDecodeException e) {
            log.error("error：{}", e.getMessage());
            throw ServiceException.CONST_token_is_not_validate;
        }
    }

    // ************************* 后台管理员认证 ********************** //
    // 生成 token
    public static String generateTokenWithUserId(Integer userId) {
        try {
            return JWT.create()
                    .withClaim("userId", userId)
                    .withClaim("createTime", System.currentTimeMillis())
                    .sign(Algorithm.HMAC256(jwtSecret)); // 加上服务器秘钥 也可以再加上用户密码
        } catch (Exception e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }

    // 从 token中获取用户id
    public static Integer getSysUserId(String token) throws ServiceException {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asInt();
        } catch (JWTDecodeException e) {
            log.error("error：{}", e.getMessage());
            throw ServiceException.CONST_token_is_not_validate;
        }
    }


}
