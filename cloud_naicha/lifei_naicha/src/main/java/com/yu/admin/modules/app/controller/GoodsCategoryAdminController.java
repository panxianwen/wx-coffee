package com.yu.admin.modules.app.controller;

import com.yu.admin.modules.app.mapper.GoodsCategoryAdminMapper;
import com.yu.admin.modules.app.pojo.GoodsCategoryAdmin;
import com.yu.admin.modules.app.service.GoodsCategoryAdminService;
import com.yu.common.annotation.NeedPermission;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "系统：商品类别管理")
@RestController
@RequestMapping("/api-system/goodsCategoryAdmin")
public class GoodsCategoryAdminController {

    @Resource
    private GoodsCategoryAdminService goodsCategoryAdminService;
    @Resource
    private GoodsCategoryAdminMapper goodsCategoryAdminMapper;

    @ApiOperation("查询全部")
    @NeedPermission("system:goodsCategory:list")
    @GetMapping("/list")
    public R<List<GoodsCategoryAdmin>> getAllGoodsCategoryAdmins() {
        return R.ok(goodsCategoryAdminService.getAllGoodsCategoryAdmins());
    }

    @ApiOperation("增加")
    @NeedPermission("system:goodsCategory:add")
    @PostMapping("")
    public R<Integer> add(@RequestBody GoodsCategoryAdmin goodsCategoryAdmin) {
        return R.ok(goodsCategoryAdminService.addGoodsCategoryAdmin(goodsCategoryAdmin));
    }

    @ApiOperation("批量删除")
    @NeedPermission("system:goodsCategory:delete")
    @DeleteMapping("/{categoryName}")
    public R<Integer> delete(@PathVariable String categoryName) {
        return R.ok(goodsCategoryAdminService.deleteGoodsCategoryAdminByName(categoryName));
    }

    @ApiOperation("修改")
    @NeedPermission("system:goodsCategory:update")
    @PutMapping("/{oldName}")
    public R<Integer> update(@PathVariable String oldName, @RequestBody GoodsCategoryAdmin goodsCategoryAdmin) {
        return R.ok(goodsCategoryAdminService.updateGoodsCategoryAdmin(oldName, goodsCategoryAdmin));
    }

    @ApiOperation("显示或隐藏该类商品")
    @NeedPermission("system:goodsCategory:update")
    @PutMapping("/showStatus/{name}")
    public R<Integer> updateCategoryShowStatus(@PathVariable String name) {
        return R.ok(goodsCategoryAdminMapper.updateCategoryShowStatus(name));
    }


}
