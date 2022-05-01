package com.yu.admin.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yu.common.annotation.NeedPermission;
import com.yu.admin.modules.system.mapper.RoleMapper;
import com.yu.admin.modules.system.mapper.RolePermissionMapper;
import com.yu.admin.modules.system.pojo.Role;
import com.yu.admin.modules.system.pojo.RolePermission;
import com.yu.admin.modules.system.pojo.vo.UpdateRolePermissionVo;
import com.yu.admin.modules.system.service.impl.RoleServiceImpl;
import com.yu.common.exception.ServiceException;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Api(tags = "系统：角色管理")
@RestController
@RequestMapping("/api-system/role")
public class RoleController {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RolePermissionMapper sysRolePermissionMapper;

    @Resource
    private RoleServiceImpl roleService;

    @ApiOperation("查询全部")
    @NeedPermission("system:role:list")
    @GetMapping("/list")
    public R<List<Role>> getAllsysRoles() throws ServiceException {
        return R.ok(roleMapper.selectList(null));
    }

    @ApiOperation("分页条件查询")
    @NeedPermission("system:role:list")
    @GetMapping("/page/{pageNo}/{pageSize}")
    public R page(@ApiParam("页数") @PathVariable Integer pageNo,
                  @ApiParam("页面大小") @PathVariable Integer pageSize,
                  @ApiParam("查询参数") @RequestParam Map<String, Object> params) throws ServiceException {
        return R.ok(roleService.listByPageAndCondition(pageNo, pageSize, params));
    }

    @ApiOperation("根据id查询")
    @NeedPermission("system:role:list")
    @GetMapping("/{sysRoleId}")
    public R detail(@PathVariable("sysRoleId") Integer sysRoleId) {
        return R.ok(roleMapper.selectById(sysRoleId));
    }

    @ApiOperation("角色的所有权限")
    @NeedPermission("system:role:list")
    @GetMapping("/perms/{sysRoleId}")
    public R getRolePermissions(@PathVariable("sysRoleId") Integer sysRoleId) {
        return R.ok(
                sysRolePermissionMapper.selectObjs(new QueryWrapper<RolePermission>()
                        .select("permission").eq("role_id", sysRoleId)
                )
        );
    }

    @ApiOperation("增")
    @NeedPermission("system:role:add")
    @PostMapping("")
    public R add(@RequestBody Role sysRole) throws ServiceException {
        return R.ok(roleMapper.insert(sysRole));
    }

    @ApiOperation("改")
    @NeedPermission("system:role:update")
    @PutMapping("")
    public R update(@RequestBody Role sysRole) throws ServiceException {
        return R.ok(roleMapper.updateById(sysRole));
    }

    @ApiOperation("批量删除角色")
    @NeedPermission("system:role:delete")
    @DeleteMapping("/batch")
    public R delete(@RequestBody List<Integer> sysRoleIdList) throws ServiceException {
        return R.ok(roleMapper.deleteBatchIds(sysRoleIdList));
    }

    @ApiOperation("修改角色的权限")
    @NeedPermission("system:role:update")
    @PutMapping("/permission")
    public R updateRolePermission(@ApiParam("角色权限表单") @RequestBody UpdateRolePermissionVo vo) throws ServiceException {
        List<String> permissions = sysRolePermissionMapper.selectPerimssionByRoleId(vo.getRoleId());
        if (permissions.contains("*")) {
            throw ServiceException.CONST_can_not_change_role_of_super_system_admin_user;
        }
        roleService.updateRolePermission(vo);
        return R.ok();
    }
}
