package com.yu.admin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yu.admin.modules.system.mapper.RoleMapper;
import com.yu.admin.modules.system.mapper.RolePermissionMapper;
import com.yu.admin.modules.system.pojo.Role;
import com.yu.admin.modules.system.pojo.RolePermission;
import com.yu.admin.modules.system.pojo.vo.UpdateRolePermissionVo;
import com.yu.admin.modules.system.service.RoleService;
import com.yu.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper sysRoleMapper;

    @Resource
    private RolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<Role> listByPageAndCondition(Integer pageNo, Integer pageSize, Map<String, Object> params) throws ServiceException {
        QueryWrapper<Role> wrapper = new QueryWrapper<Role>();
        if (params == null)
            return sysRoleMapper.selectPage(new Page<>(pageNo, pageSize), wrapper).getRecords();

        params.forEach((key, value) -> {
            wrapper.eq(key, value);
        });
        return sysRoleMapper.selectPage(new Page<>(pageNo, pageSize), wrapper).getRecords();
    }

    @Transactional
    @Override
    public void updateRolePermission(UpdateRolePermissionVo vo) throws ServiceException {
        sysRolePermissionMapper.delete(new QueryWrapper<RolePermission>().eq("role_id", vo.getRoleId()));
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(vo.getRoleId());
        for (String permission : vo.getPermissions()) {
            rolePermission.setPermission(permission);
            sysRolePermissionMapper.insert(rolePermission);
        }
        log.info("[更新角色权限] {}", vo);
    }

}
