package com.yu.admin.modules.system.pojo.dto;

import com.yu.admin.modules.system.pojo.SysUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SysUserDTO extends SysUser {

    private String roleName;
    @ApiModelProperty("令牌")
    private String token;
    private List<String> permissions;
}
