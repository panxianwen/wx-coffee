package com.yu.admin.modules.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel("角色的权限(可以不止一个)")
@Data
@TableName("sys_role_permission")
public class RolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer roleId;

    @ApiModelProperty("权限 eg:system:user:add")
    private String permission;


}
