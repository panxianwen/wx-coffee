package com.yu.app.controller;

import com.yu.app.pojo.User;
import com.yu.app.pojo.form.LoginByWeixinForm;
import com.yu.app.pojo.form.UpdateUserForm;
import com.yu.app.service.impl.UserServiceImpl;
import com.yu.common.annotation.AccessLimiter;
import com.yu.common.annotation.NeedLogin;
import com.yu.common.exception.ServiceException;
import com.yu.common.util.jwt.JWTUtil;
import com.yu.common.util.result.R;
import com.yu.common.util.session.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户服务")
@RestController
@Slf4j
@RequestMapping("/api-app/user")
public class UserController {
    @Resource
    private UserServiceImpl userService;

    // TODO
    @ApiOperation("开发测试时开发的登录接口")
    @PostMapping("/login/dev")
    public R<User> login(String secretPassword) throws Exception {
        if (!"123456".equals(secretPassword)) {
            throw ServiceException.CONST_login_failed;
        }
        // 测试开发环境，必须事先到数据库里面去插入wxOpenid=0的数据
        User user = userService.getUser("oxci95SnSaCpN5NAvv66T4XYDVR8"); // 陈亚茹的微信的openid
        SessionUtil.setUserSession(user);
        log.info("[开发环境，用户登录] {}", user);
        return R.ok(user);
    }

    @ApiOperation("通过微信登录")
    @PostMapping("/login/weixin")
    public R<User> loginByWx(@RequestBody LoginByWeixinForm form) throws Exception {
        User user = userService.loginByWeixin(form);
        //log.info("-->[user] {}", user);
        return R.ok(user);
    }

    @ApiOperation("退出登录")
    @DeleteMapping("/logout")
    public R logout(HttpServletRequest request) throws ServiceException {
        String token = SessionUtil.getToken(request);
        userService.logout(JWTUtil.getWxOpenid(token), token);
        return R.ok();
    }

    @ApiOperation("根据token获取用户数据")
    @NeedLogin
    @GetMapping("/info")
    public R<User> getUserInfo(HttpServletRequest request) throws ServiceException {
        String token = SessionUtil.getToken(request);
        User user = userService.getUser(JWTUtil.getWxOpenid(token));
        user.setToken(token);
        return R.ok(user);
    }

    @ApiOperation("更新信息")
    @NeedLogin
    @AccessLimiter
    @PutMapping
    public R<Integer> updateUser(@ApiParam("更新学生信息表单") @RequestBody UpdateUserForm form, HttpServletRequest request) throws Exception {
        return R.ok(userService.updateUser(form, SessionUtil.getCurrentWxOpenidFromRequest(request)));
    }
}
