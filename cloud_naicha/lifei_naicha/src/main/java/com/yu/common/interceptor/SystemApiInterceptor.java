package com.yu.common.interceptor;

import com.yu.admin.modules.system.pojo.dto.SysUserDTO;
import com.yu.admin.modules.system.service.SysUserService;
import com.yu.common.annotation.NeedPermission;
import com.yu.common.constant.Const;
import com.yu.common.exception.ServiceException;
import com.yu.common.service.RedisService;
import com.yu.common.service.cache.LocalCache;
import com.yu.common.util.jwt.JWTUtil;
import com.yu.common.util.session.AdminSessionUtil;
import com.yu.common.util.session.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统后台api拦截器
 */
@Slf4j
@Component
public class SystemApiInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ((handler instanceof HandlerMethod)) {
            NeedPermission needPermission = ((HandlerMethod) handler).getMethod().getAnnotation(NeedPermission.class);
            if (needPermission != null) {
                String token = SessionUtil.getToken(request);
                if (StringUtils.isEmpty(token)) {
                    log.error("未携带token，拦截，请求路径[{}][{}]", request.getMethod(), request.getServletPath());
                    return false;
                }

                // 检测token的有效性
                if (!JWTUtil.verify(token))
                    throw ServiceException.CONST_token_is_not_validate;

                Integer sysUserId = JWTUtil.getSysUserId(token);
                if (StringUtils.isEmpty(token) || !sysUserService.checkLogin(sysUserId, token)) {
                    log.error("[后台] 拦截未登录 请求路径[{}]", request.getServletPath());
                    throw ServiceException.CONST_user_not_login;
                }

                // TODO 管理员的会话信息可以缓存到二级内存缓存，(管理员比较少，而且管理员要一直用到权限信息)
                SysUserDTO sysUserDTO = LocalCache.get(Const.CONST_sys_user_session_redis_prefix + sysUserId);
                if (sysUserDTO == null) {
                    sysUserDTO = redisService.get(Const.CONST_sys_user_session_redis_prefix + sysUserId, SysUserDTO.class);
                    LocalCache.set(Const.CONST_sys_user_session_redis_prefix + sysUserId, sysUserDTO, redisService.getExpire(Const.CONST_sys_user_session_redis_prefix + sysUserId));
                }

                // 将认证后的sysUserId放到request的属性里
                request.setAttribute(Const.CONST_sys_user_id, sysUserId);
                // 检验权限
                boolean hasPermission = AdminSessionUtil.hasPermission(needPermission.value(), sysUserDTO.getPermissions());
                if (!hasPermission) {
                    log.error("[后台] 拦截 没有[{}]权限 请求路径[{}]", needPermission.value(), request.getServletPath());
                    throw ServiceException.CONST_not_authorized;
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

}
