package com.yu.admin.modules.system.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel("角色权限表单")
@Data
public class UpdateRolePermissionVo {
    private Integer roleId;
    private List<String> permissions;
}
