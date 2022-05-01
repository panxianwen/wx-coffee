package com.yu.admin.modules.app.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yu.common.annotation.NeedPermission;
import com.yu.admin.modules.app.mapper.GoodsAdminMapper;
import com.yu.admin.modules.app.service.GoodsAdminService;
import com.yu.admin.modules.app.pojo.GoodsAdmin;
import com.yu.common.exception.ServiceException;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "系统：商铺管理")
@RestController
@RequestMapping("/api-system/goodsAdmin")
public class GoodsAdminController {

    @Resource
    private GoodsAdminService goodsAdminService;
    @Resource
    private GoodsAdminMapper goodsAdminMapper;


    @ApiOperation("分页查询")
    @NeedPermission("system:goods:list")
    @GetMapping("/page")
    public R<Page<GoodsAdmin>> getGoodsAdminByPage( @RequestParam(defaultValue = "1") int pageNo,
                                                        @RequestParam(defaultValue = "10") int pageSize) {
        return R.ok(goodsAdminService.getGoodsAdminByPage(pageNo, pageSize));
    }

    @ApiOperation("查询一个商品")
    @NeedPermission("system:goods:list")
    @GetMapping("/{goodsId}")
    public R<GoodsAdmin> getGoodsById( @PathVariable Integer goodsId) {
        return R.ok(goodsAdminService.getGoodsById(goodsId));
    }

    @ApiOperation("增加")
    @NeedPermission("system:goods:add")
    @PostMapping("")
    public R<Integer> add(@RequestBody GoodsAdmin goodsAdmin) {
        return R.ok(goodsAdminService.addGoodsAdmin(goodsAdmin));
    }

    @ApiOperation("批量删除")
    @NeedPermission("system:goods:delete")
    @DeleteMapping("/batch")
    public R<Integer> delete(@RequestBody List<Integer> idList) {
        return R.ok(goodsAdminService.deleteGoodsAdminBatchIds(idList));
    }

    @ApiOperation("修改")
    @NeedPermission("system:goods:update")
    @PutMapping("")
    public R<Integer> update(@RequestBody GoodsAdmin goodsAdmin) {
        return R.ok(goodsAdminService.updateGoodsAdmin(goodsAdmin));
    }

    @ApiOperation("下架或上架商品")
    @NeedPermission("system:goods:update")
    @PutMapping("/updateSellStatus/{goodsId}")
    public R<Integer> updateSellStatus(@PathVariable Integer goodsId) {
        return R.ok(goodsAdminMapper.updateSellStatus(goodsId));
    }

    @ApiOperation("更新商品的图片")
    @NeedPermission("system:goods:update")
    @RequestMapping("/image")
    public R<Integer> updateGoodsImage(@RequestParam Integer goodsId, @RequestParam MultipartFile file) throws ServiceException { // file的名字要和前端input里的name一致
        return R.ok(goodsAdminService.updateGoodsImage(goodsId, file));
    }
}
