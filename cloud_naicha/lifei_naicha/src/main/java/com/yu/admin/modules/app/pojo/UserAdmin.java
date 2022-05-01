package com.yu.admin.modules.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("")
@Data
@TableName("user")
public class UserAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty("微信的openid")
    @TableId(type = IdType.INPUT)
    private String wxOpenid;

    @ApiModelProperty("姓名")
    private String name;

//    @ApiModelProperty("收货地址")
//    private String address;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("性别")
    private Boolean sex;

    @ApiModelProperty("微信头像")
    private String wxAvatar;

    @ApiModelProperty("账号激活状态")
    private Boolean status;

}
