package com.yu.admin.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yu.admin.modules.app.mapper.GoodsAdminMapper;
import com.yu.admin.modules.app.mapper.GoodsPropertyAdminMapper;
import com.yu.admin.modules.app.pojo.GoodsAdmin;
import com.yu.admin.modules.app.pojo.GoodsPropertyAdmin;
import com.yu.admin.modules.app.service.GoodsAdminService;
import com.yu.common.annotation.NeedPermission;
import com.yu.common.enums.GoodsPropertyCategory;
import com.yu.common.exception.ServiceException;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "系统：商品属性管理")
@RestController
@RequestMapping("/api-system/goodsPropertyAdmin")
public class GoodsPropertyAdminController {

    @Resource
    private GoodsAdminService goodsAdminService;
    @Resource
    private GoodsAdminMapper goodsAdminMapper;
    @Resource
    private GoodsPropertyAdminMapper goodsPropertyAdminMapper;

    @ApiOperation("设置商品的默认属性")
    @NeedPermission("system:goods:update")
    @PutMapping("/setDefault/{goodsPropertyId}")
    public R<Integer> setDefaultGoodsProperty(@PathVariable String goodsPropertyId) throws ServiceException {
        GoodsPropertyAdmin goodsProperty = goodsPropertyAdminMapper.selectById(goodsPropertyId);
        if (GoodsPropertyCategory.ENUM_jia_liao.value.equals(goodsProperty.getCategory()))  // 加料
            throw ServiceException.CONST_jia_liao_can_not_set_default_property;

        // 先重置默认的状态
        goodsPropertyAdminMapper.resetDefaultStatusOfSameGoodsProperty(goodsProperty.getGoodsId(), goodsProperty.getCategory());
        goodsProperty.setIsDefault(true);
        // 更新商品的默认价格
        if (GoodsPropertyCategory.ENUM_size.value.equals(goodsProperty.getCategory())) { // 是大小属性时更新默认价格
            goodsAdminMapper.updateGoodsDefaultPrice(goodsProperty.getGoodsId(), goodsProperty.getRealPrice());
        }

        return R.ok(goodsPropertyAdminMapper.updateById(goodsProperty));
    }

    @ApiOperation("添加商品属性")
    @NeedPermission("system:goods:update")
    @PostMapping
    public R<Integer> addGoodsProperty(@RequestBody GoodsPropertyAdmin goodsProperty) {
        if (GoodsPropertyCategory.ENUM_jia_liao.value.equals(goodsProperty.getCategory())) { // 属性种类为: 加料
            goodsProperty.setIsDefault(false);
        } else {
            // 同类属性的数量
            Integer sameCategoryPropertyCount = goodsPropertyAdminMapper.selectCount(
                    new QueryWrapper<GoodsPropertyAdmin>().eq("goods_id", goodsProperty.getGoodsId())
                            .eq("category", goodsProperty.getCategory())
            );
            if (sameCategoryPropertyCount <= 0) { // 第一个加入的属性就设置为默认属性
                goodsProperty.setIsDefault(true);
                if (GoodsPropertyCategory.ENUM_size.value.equals(goodsProperty.getCategory())) // 属性为大小时更换默认价格
                    goodsAdminMapper.updateGoodsDefaultPrice(goodsProperty.getGoodsId(), goodsProperty.getRealPrice());
            } else
                goodsProperty.setIsDefault(false);
        }
        return R.ok(goodsPropertyAdminMapper.insert(goodsProperty));
    }

    @ApiOperation("更新商品属性")
    @NeedPermission("system:goods:update")
    @PutMapping
    public R<Integer> updateGoodsCategory(@RequestBody GoodsPropertyAdmin goodsProperty) {
        if (goodsProperty.getIsDefault() && GoodsPropertyCategory.ENUM_size.value.equals(goodsProperty.getCategory())) {
            // 同时更新默认价格
            goodsAdminMapper.updateGoodsDefaultPrice(goodsProperty.getGoodsId(), goodsProperty.getRealPrice());
        } else {
            goodsProperty.setIsDefault(null); // 忽略is_default字段
        }
        return R.ok(goodsPropertyAdminMapper.updateById(goodsProperty));

    }

    @ApiOperation("删除商品属性")
    @NeedPermission("system:goods:update")
    @DeleteMapping("/{goodsPropertyId}")
    public R<Integer> deleteGoodsCategory(@PathVariable String goodsPropertyId) {
        GoodsPropertyAdmin goodsProperty = goodsPropertyAdminMapper.selectById(goodsPropertyId);
        // 如果不是默认属性或是加料类型就直接删除
        if (goodsProperty.getIsDefault() || GoodsPropertyCategory.ENUM_jia_liao.value.equals(goodsProperty.getCategory()))
            return R.ok(goodsPropertyAdminMapper.deleteById(goodsPropertyId));

        List<GoodsPropertyAdmin> goodsPropertyList = goodsPropertyAdminMapper.selectList(
                new QueryWrapper<GoodsPropertyAdmin>().eq("goods_id", goodsProperty.getGoodsId())
                        .eq("category", goodsProperty.getCategory())
        );
        if (CollectionUtils.isEmpty(goodsPropertyList)) // 该类属性只有它一个也直接删除
            return R.ok(goodsPropertyAdminMapper.deleteById(goodsPropertyId));

        // 重新设置一个默认属性
        GoodsPropertyAdmin randomGoodsProperty = goodsPropertyList.get(0);
        randomGoodsProperty.setIsDefault(true);
        goodsPropertyAdminMapper.updateById(randomGoodsProperty);
        // 更新商品的默认价格
        if (GoodsPropertyCategory.ENUM_size.value.equals(goodsProperty.getCategory()))
            goodsAdminMapper.updateGoodsDefaultPrice(goodsProperty.getGoodsId(), goodsProperty.getRealPrice());

        return R.ok(goodsPropertyAdminMapper.deleteById(goodsPropertyId));
    }

}
