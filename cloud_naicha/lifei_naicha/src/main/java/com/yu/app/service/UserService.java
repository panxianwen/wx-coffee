package com.yu.app.service;


import com.yu.app.pojo.User;
import com.yu.app.pojo.form.LoginByWeixinForm;
import com.yu.app.pojo.form.UpdateUserForm;
import com.yu.common.exception.ServiceException;

public interface UserService {

    // 通过微信小程序获取的code在服务器获取微信openid登录，没有就注册
    User loginByWeixin(LoginByWeixinForm form) throws ServiceException;

    // 检测是否登录
    boolean checkLogin(String wxOpenid,String token ) throws ServiceException;

    // 退出登录
    void logout(String wxOpenid,String token ) throws ServiceException;

    // 获取学生详情信息
    User getUser(String wxOpenid);

    // 更新用户信息
    int updateUser(UpdateUserForm form, String wxOpenid) throws Exception;

}
