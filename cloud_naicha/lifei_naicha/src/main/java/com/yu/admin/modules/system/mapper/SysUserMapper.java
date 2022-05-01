package com.yu.admin.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yu.admin.modules.system.pojo.SysUser;
import com.yu.admin.modules.system.pojo.dto.SysUserDTO;
import com.yu.admin.modules.system.pojo.vo.SysUserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SysUserMapper extends BaseMapper<SysUser> {

//    @Select("select sys_user.id, sys_user.`username`, sys_user.`status`,\n" +
//            " sys_user_role.`role_id` as roleId from sys_user \n" +
//            " left join sys_user_role  on  sys_user.`id` = sys_user_role.`user_id`; ")

//    @Select("select s.id, s.username, s.status, \n" +
//            " r.role_id as roleId from sys_user s \n" +
//            " left join sys_user_role r  on  s.id = r.user_id and r.role_id != null")
    @Select("select sys_user.*, sys_user_role.role_id from sys_user, sys_user_role " +
        "where sys_user.id = sys_user_role.user_id ")
    List<SysUser> getAllUserVOs();

    @Select("select s.id, s.username, s.status, \n" +
            " r.role_id as roleId from sys_user s \n" +
            " left join sys_user_role r  on  s.id = r.user_id \n" +
            " where s.username = #{username} and s.password = #{password}")
    SysUser getUserByNameAndPwd(String username, String password);
}
