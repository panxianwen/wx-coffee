package com.yu.admin.modules.system.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("视图层 用户对象")
@Data
public class SysUserVo {
    @TableId
    private Integer id;

    private String username;

    private Integer roleId;

    private String roleName;

    @ApiModelProperty("账号激活状态")
    private Boolean status;

}
