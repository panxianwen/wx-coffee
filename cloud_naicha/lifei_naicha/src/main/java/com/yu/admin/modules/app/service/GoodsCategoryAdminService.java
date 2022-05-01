package com.yu.admin.modules.app.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yu.admin.modules.app.mapper.GoodsAdminMapper;
import com.yu.admin.modules.app.mapper.GoodsCategoryAdminMapper;
import com.yu.admin.modules.app.pojo.GoodsAdmin;
import com.yu.admin.modules.app.pojo.GoodsCategoryAdmin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class GoodsCategoryAdminService {

    @Resource
    private GoodsCategoryAdminMapper goodsCategoryAdminMapper;
    @Resource
    private GoodsAdminMapper goodsAdminMapper;


    /**
     * 查询所有
     */
    public List<GoodsCategoryAdmin> getAllGoodsCategoryAdmins() {
        return goodsCategoryAdminMapper.selectList(
                new QueryWrapper<GoodsCategoryAdmin>().orderByAsc("display_order")
        );
    }

    // 增加
    @Transactional
    public int addGoodsCategoryAdmin(GoodsCategoryAdmin goodsCategoryAdmin) {
        return goodsCategoryAdminMapper.insert(goodsCategoryAdmin);
    }

    // 删除
    @Transactional(rollbackFor = Exception.class)
    public int deleteGoodsCategoryAdminByName(String categoryName) {
        goodsAdminMapper.delete(new QueryWrapper<GoodsAdmin>().eq("goods_category_name", categoryName));
        return goodsCategoryAdminMapper.deleteById(categoryName);
    }

    // 修改
    @Transactional
    public int updateGoodsCategoryAdmin(String oldName, GoodsCategoryAdmin goodsCategoryAdmin) {
        goodsAdminMapper.updateGoodsCategory(oldName, goodsCategoryAdmin.getName());
        return goodsCategoryAdminMapper.updateGoodsCategoryAdmin(
                oldName, goodsCategoryAdmin.getName(), goodsCategoryAdmin.getDisplayOrder());
    }
}
