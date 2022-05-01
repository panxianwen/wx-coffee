package com.yu.admin.modules.auth.controller;

import com.yu.admin.modules.system.pojo.dto.SysUserDTO;
import com.yu.admin.modules.system.pojo.vo.SysUserLoginVO;
import com.yu.admin.modules.system.pojo.vo.UpdatePasswordVo;
import com.yu.admin.modules.system.service.SysUserService;
import com.yu.common.annotation.NeedPermission;
import com.yu.common.exception.ServiceException;
import com.yu.common.util.result.R;
import com.yu.common.util.session.AdminSessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "系统：后台认证授权")
@RestController
@RequestMapping("/api-system/auth")
public class AuthController {
    @Resource
    private SysUserService sysUserService;

    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public R<SysUserDTO> login(@RequestBody SysUserLoginVO sysUserLoginVo,
                               HttpServletRequest request) throws Exception {
        return R.ok(sysUserService.login(sysUserLoginVo, request));
    }


    @ApiOperation("退出登录")
    @DeleteMapping("/logout")
    public R logout(HttpServletRequest request) throws ServiceException {
        sysUserService.logout(AdminSessionUtil.getCurrentSysUserId(request), AdminSessionUtil.getToken(request));
        return R.ok();
    }

    @ApiOperation("获取登录用户信息")
    @NeedPermission
    @GetMapping("/userInfo")
    public R<SysUserDTO> getLoginUserInfo(HttpServletRequest request) throws ServiceException {
        return R.ok(AdminSessionUtil.getCurrentSysUserDTOFromRequest(request));
    }

    @ApiOperation("修改密码")
    @NeedPermission
    @PutMapping("/password")
    public R<Integer> updatePassword(@RequestBody UpdatePasswordVo params, HttpServletRequest request) throws Exception {
        return R.ok(sysUserService.updatePassword(AdminSessionUtil.getCurrentSysUserId(request), params));
    }


}
