package com.yu.admin.modules.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yu.admin.modules.system.mapper.RoleMapper;
import com.yu.admin.modules.system.mapper.RolePermissionMapper;
import com.yu.admin.modules.system.mapper.SysUserMapper;
import com.yu.admin.modules.system.pojo.SysUser;
import com.yu.admin.modules.system.pojo.dto.SysUserDTO;
import com.yu.admin.modules.system.pojo.vo.SysUserLoginVO;
import com.yu.admin.modules.system.pojo.vo.UpdatePasswordVo;
import com.yu.admin.modules.system.service.SysUserService;
import com.yu.common.constant.Const;
import com.yu.common.exception.ServiceException;
import com.yu.common.service.RedisService;
import com.yu.common.service.cache.LocalCache;
import com.yu.common.util.GeneratorUtil;
import com.yu.common.util.session.AdminSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private RedisService redisService;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Transactional
    public SysUserDTO login(SysUserLoginVO loginVo, HttpServletRequest request) throws Exception {
        // 校对验证码
//        String verifyCode = String.valueOf(redisService.get(Const.CONST_verify_code_redis_prefix + loginVo.getUuid()));
//        redisService.del(Const.CONST_verify_code_redis_prefix + loginVo.getUuid());
//        if (StringUtils.isEmpty(verifyCode) || !verifyCode.equals(loginVo.getVerifyCode()))
//            throw ServiceException.CONST_verify_code_error_or_expire;

//        SysUser user = sysUserMapper.selectOne(new QueryWrapper<SysUser>()
//                .eq("username", loginVo.getUsername())
//                .eq("password", GeneratorUtil.md5Base64(loginVo.getPassword())));
        SysUser user = sysUserMapper.getUserByNameAndPwd(loginVo.getUsername(), GeneratorUtil.md5Base64(loginVo.getPassword()));
        if (user == null) {
            log.error("[管理员登录失败] {}", loginVo);
            throw ServiceException.CONST_login_failed;
        }

        if (!user.getStatus()) {
            log.error("[管理员登录失败 账号冻结] {}", user);
            throw ServiceException.CONST_user_is_forbidden;
        }

        SysUserDTO userDTO = new SysUserDTO();
        BeanUtils.copyProperties(user, userDTO, "password");
        // 获取权限
        userDTO.setPermissions(rolePermissionMapper.selectPerimssionByRoleId(user.getId()));
        userDTO.setRoleName(roleMapper.selectById(user.getRoleId()).getName());
        AdminSessionUtil.setSysUserSession(userDTO);

        log.info("[管理员登录] {}", userDTO);
        return userDTO;
    }

    public boolean checkLogin(Integer sysUserId, String token) throws ServiceException {
        boolean hasLogin = LocalCache.hasKey(Const.CONST_sys_user_session_redis_prefix + sysUserId);
        if (hasLogin)
            return true;
        hasLogin = redisService.hasKey(Const.CONST_sys_user_session_redis_prefix + sysUserId);
        if (hasLogin) {
            LocalCache.set(Const.CONST_sys_user_session_redis_prefix + sysUserId,
                    redisService.get(Const.CONST_sys_user_session_redis_prefix + sysUserId, SysUserDTO.class));
        }
        return hasLogin;
    }

    public void logout(Integer sysUserId, String token) throws ServiceException {
        redisService.del(Const.CONST_sys_user_session_redis_prefix + sysUserId);
        LocalCache.del(Const.CONST_sys_user_session_redis_prefix + sysUserId);
    }

    @Transactional
    @Override
    public int updatePassword(Integer sysUserId, UpdatePasswordVo params) throws ServiceException {
        if (StringUtils.isEmpty(params.getOldPassword()) || StringUtils.isEmpty(params.getNewPassword())
                || params.getNewPassword().length() < 6 || params.getNewPassword().length() > 18)
            throw ServiceException.CONST_password_pattern_error;
        if (params.getOldPassword().equals(params.getNewPassword()))
            throw ServiceException.CONST_new_password_can_not_equals_old_password;

        SysUser user = sysUserMapper.selectById(sysUserId);
        if (!GeneratorUtil.md5Base64(params.getOldPassword()).equals(user.getPassword()))
            throw ServiceException.CONST_old_password_error;

        user.setPassword(GeneratorUtil.md5Base64(params.getNewPassword()));
        return sysUserMapper.updateById(user);
    }


}
