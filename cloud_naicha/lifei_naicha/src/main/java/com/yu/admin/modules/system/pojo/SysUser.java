package com.yu.admin.modules.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel("后台管理员")
@Data
@TableName("sys_user")
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private String username;
    @TableField(exist=false)
    private Integer roleId;
    private String password;
    @ApiModelProperty("1表示账号激活状态")
    private Boolean status;

}
