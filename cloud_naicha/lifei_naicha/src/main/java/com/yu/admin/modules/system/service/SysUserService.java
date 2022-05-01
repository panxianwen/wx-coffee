package com.yu.admin.modules.system.service;

import com.yu.admin.modules.system.pojo.dto.SysUserDTO;
import com.yu.admin.modules.system.pojo.vo.SysUserLoginVO;
import com.yu.admin.modules.system.pojo.vo.UpdatePasswordVo;
import com.yu.common.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @date 2020-11-28 00:39:54
 */
public interface SysUserService {
    /**
     * 登录
     *
     * @param loginVo
     * @return SysUserDTO
     * @throws Exception
     */
    SysUserDTO login(SysUserLoginVO loginVo, HttpServletRequest request) throws Exception;

    /**
     * @param token
     * @return
     */
    boolean checkLogin(Integer sysUserId, String token) throws ServiceException;

    /**
     * 退出登录
     *
     * @param token
     */
    void logout(Integer sysUserId, String token) throws ServiceException;
;

    /**
     * 修改密码
     * @return
     */
    int updatePassword(Integer sysUserId, UpdatePasswordVo params) throws ServiceException;
}

