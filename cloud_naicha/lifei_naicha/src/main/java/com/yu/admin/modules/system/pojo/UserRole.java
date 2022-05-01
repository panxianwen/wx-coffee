package com.yu.admin.modules.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel("")
@Data
@TableName("sys_user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;


}
