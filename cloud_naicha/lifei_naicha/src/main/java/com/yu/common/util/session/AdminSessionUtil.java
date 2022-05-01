package com.yu.common.util.session;

import com.yu.admin.modules.system.pojo.dto.SysUserDTO;
import com.yu.common.constant.Const;
import com.yu.common.exception.ServiceException;
import com.yu.common.service.RedisService;
import com.yu.common.service.cache.LocalCache;
import com.yu.common.util.jwt.JWTUtil;
import com.yu.common.util.spring.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
public class AdminSessionUtil {
    private static RedisService redisService = SpringContextUtil.getBeanByClass(RedisService.class);

    /**
     * 添加会话缓存  缓存到redis里，CONST_sys_user_redis_prefix + token 作为key
     */
    public static void setSysUserSession(SysUserDTO sysUserDTO) {
        sysUserDTO.setToken(JWTUtil.generateTokenWithUserId(sysUserDTO.getId()));
        redisService.set(Const.CONST_sys_user_session_redis_prefix + sysUserDTO.getId(), sysUserDTO, Const.CONST_one_month);
        log.info("[添加会话缓存] {}", sysUserDTO);
    }

    // 当前用户的id
    public static Integer getCurrentSysUserId(HttpServletRequest request) {
        return Integer.valueOf(request.getAttribute(Const.CONST_sys_user_id).toString());
    }

    public static SysUserDTO getCurrentSysUserDTOFromRequest(HttpServletRequest request) {
        Integer sysUserId = getCurrentSysUserId(request);
        SysUserDTO sysUserDTO = LocalCache.get(Const.CONST_sys_user_session_redis_prefix + sysUserId);
        if (sysUserDTO == null) {
            sysUserDTO = redisService.get(Const.CONST_sys_user_session_redis_prefix + sysUserId, SysUserDTO.class);
            LocalCache.set(Const.CONST_sys_user_session_redis_prefix + sysUserId, sysUserDTO, redisService.getExpire(Const.CONST_sys_user_session_redis_prefix + sysUserId));
        }
        return sysUserDTO;
    }

    // 找请求里携带的token
    public static String getToken(HttpServletRequest request) throws ServiceException {
        String token = request.getParameter(Const.CONST_token); // 从url后面的参数里找
        if (StringUtils.isEmpty(token)) // 从header里面找
            token = request.getHeader(Const.CONST_token);
        if (token == null)
            throw ServiceException.CONST_user_not_login;
        return token;
    }

    /**
     * 是否含有某项权限, 根据前缀去匹配
     *
     * @param needPermission 标匹配权限 eg: 需要权限system:user:update 如果有system:user权限即可
     * @return boolean
     */
    public static boolean hasPermission(String needPermission, List<String> permissionList) throws ServiceException {
        if (StringUtils.isEmpty(needPermission))
            return true;

        // 拥有的权限
        for (String userPermission : permissionList) {
            if (userPermission.startsWith(needPermission) || "*".equals(userPermission))
                return true;
        }
        return false;
    }
}
