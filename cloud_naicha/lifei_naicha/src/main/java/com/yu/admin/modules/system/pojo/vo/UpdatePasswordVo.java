package com.yu.admin.modules.system.pojo.vo;

import lombok.Data;

@Data
public class UpdatePasswordVo {
    private String oldPassword;

    private String newPassword;
}
