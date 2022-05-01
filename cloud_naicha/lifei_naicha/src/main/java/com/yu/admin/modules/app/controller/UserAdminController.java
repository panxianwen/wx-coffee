package com.yu.admin.modules.app.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yu.admin.modules.app.pojo.UserAdmin;
import com.yu.admin.modules.app.service.UserAdminService;
import com.yu.admin.modules.system.pojo.Role;
import com.yu.common.annotation.AccessLimiter;
import com.yu.common.annotation.NeedPermission;
import com.yu.common.util.http.HttpUtil;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "系统：用户管理")
@RestController
@RequestMapping("/api-system/userAdmin")
public class UserAdminController {

    @Resource
    private UserAdminService userAdminService;

    @ApiOperation("查询全部")
    @NeedPermission("system:user:list")
    @GetMapping("/list")
    public R<List<UserAdmin>> getAllUserAdmins() {
        return R.ok(userAdminService.getAllUserAdmins());
    }

    @ApiOperation("分页查询")
    @NeedPermission("system:user:list")
    @GetMapping("/page")
    public R<Page<UserAdmin>> getuserAdminByPage(@RequestParam(defaultValue = "1") int pageNo,
                                                 @RequestParam(defaultValue = "10") int pageSize) {
        return R.ok(userAdminService.getUserAdminByPage(pageNo, pageSize));
    }

    @ApiOperation("增加")
    @NeedPermission("system:user:add")
    @PostMapping("")
    public R<Integer> add(@RequestBody UserAdmin userAdmin) {
        return R.ok(userAdminService.addUserAdmin(userAdmin));
    }

    @ApiOperation("批量删除")
    @NeedPermission("system:user:delete")
    @DeleteMapping("/batch")
    public R<Integer> delete(@RequestBody List<Integer> idList) {
        return R.ok(userAdminService.deleteUserAdminBatchIds(idList));
    }

    @ApiOperation("修改")
    @NeedPermission("system:user:update")
    @PutMapping("")
    public R<Integer> update(@RequestBody UserAdmin userAdmin) {
        return R.ok(userAdminService.updateUserAdmin(userAdmin));
    }
}
