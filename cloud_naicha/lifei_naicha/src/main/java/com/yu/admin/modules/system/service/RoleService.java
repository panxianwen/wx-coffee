package com.yu.admin.modules.system.service;

import com.yu.admin.modules.system.pojo.Role;
import com.yu.admin.modules.system.pojo.vo.UpdateRolePermissionVo;
import com.yu.common.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * @date 2020-11-29 18:17:30
 */
public interface RoleService {

    /**
     * 分页条件查询
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @param params   查询参数
     * @return List<SysRole>
     */
    List<Role> listByPageAndCondition(Integer pageNo, Integer pageSize, Map<String, Object> params) throws ServiceException;

    /**
     * 修改角色的权限
     *
     * @param vo
     */
    void updateRolePermission(UpdateRolePermissionVo vo) throws ServiceException;
}

