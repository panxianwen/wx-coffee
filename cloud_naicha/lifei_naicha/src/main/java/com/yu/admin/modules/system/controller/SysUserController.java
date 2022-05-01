package com.yu.admin.modules.system.controller;

import com.yu.common.annotation.NeedPermission;
import com.yu.admin.modules.system.mapper.RolePermissionMapper;
import com.yu.admin.modules.system.mapper.SysUserMapper;
import com.yu.admin.modules.system.pojo.SysUser;
import com.yu.admin.modules.system.pojo.vo.SysUserVo;
import com.yu.common.exception.ServiceException;
import com.yu.common.util.GeneratorUtil;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Api(tags = "系统：系统管理员")
@RestController
@RequestMapping("/api-system/sysUser")
public class SysUserController {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @ApiOperation("查询全部")
    @NeedPermission("system:sysUser:list")
    @GetMapping("/list")
    public R<List<SysUser>> getAllSysUsers() throws ServiceException {
        return R.ok(sysUserMapper.getAllUserVOs());
    }

    @ApiOperation("根据id查询")
    @NeedPermission("system:sysUser:info")
    @GetMapping("/{sysUserId}")
    public R detail(@PathVariable("sysUserId") Integer sysUserId) {
        return R.ok(sysUserMapper.selectById(sysUserId));
    }

    @ApiOperation("增")
    @NeedPermission("system:sysUser:add")
    @PostMapping("")
    public R add(@RequestBody SysUser sysUser) throws ServiceException {
        sysUser.setPassword(GeneratorUtil.md5Base64("123456"));
        return R.ok(sysUserMapper.insert(sysUser));
    }

    @ApiOperation("改")
    @NeedPermission("system:sysUser:update")
    @PutMapping("")
    public R update(@RequestBody SysUser sysUser) throws ServiceException {
        sysUser.setPassword(null);
        return R.ok(sysUserMapper.updateById(sysUser));
    }

    @ApiOperation("批量删")
    @NeedPermission("system:sysUser:delete")
    @DeleteMapping("/{sysUserId}")
    public R deleteBatch(@RequestBody Integer sysUserId) throws ServiceException {
        if ( rolePermissionMapper.selectPermissionByUserId(sysUserId).contains("*"))
            throw ServiceException.CONST_can_not_change_role_of_super_system_admin_user;
        return R.ok(sysUserMapper.deleteById(sysUserId));
    }

    @ApiOperation("更新账号激活状态")
    @NeedPermission("system:sysUser:update")
    @PutMapping("/status/{sysUserId}/{status}")
    public R updateStatus(@ApiParam("sysUserId") @PathVariable Integer sysUserId,
                          @ApiParam("status") @PathVariable Boolean status) throws ServiceException {
        SysUser sysUser = new SysUser();
        sysUser.setId(sysUserId);
        sysUser.setStatus(status);
        return R.ok(sysUserMapper.updateById(sysUser));
    }

    @ApiOperation("重置密码为123456")
    @NeedPermission("system:sysUser:update")
    @PutMapping("/resetPassword/{sysUserId}")
    public R resetPassword(@ApiParam("sysUserId") @PathVariable Integer sysUserId) throws ServiceException {
        SysUser sysUser = new SysUser();
        sysUser.setId(sysUserId);
        sysUser.setPassword(GeneratorUtil.md5Base64("123456"));
        return R.ok(sysUserMapper.updateById(sysUser));
    }

    @ApiOperation("设置用户的角色")
    @NeedPermission("system:sysUser:update")
    @PutMapping("/role/{userId}/{roleId}")
    public R setRoleOfSysUser(@PathVariable Integer userId, @PathVariable Integer roleId) throws ServiceException {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setRoleId(roleId);
        if ( rolePermissionMapper.selectPermissionByUserId(userId).contains("*"))
            throw ServiceException.CONST_can_not_change_role_of_super_system_admin_user;

        return R.ok(sysUserMapper.updateById(sysUser));
    }
}
