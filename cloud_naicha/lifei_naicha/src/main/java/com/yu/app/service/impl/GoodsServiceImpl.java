package com.yu.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yu.app.mapper.GoodsCategoryMapper;
import com.yu.app.mapper.GoodsMapper;
import com.yu.app.mapper.GoodsPropertyMapper;
import com.yu.app.pojo.Goods;
import com.yu.app.pojo.GoodsCategory;
import com.yu.app.pojo.GoodsProperty;
import com.yu.app.pojo.vo.GoodsMenuVO;
import com.yu.app.pojo.vo.GoodsVO;
import com.yu.app.pojo.vo.SameCategoryPropertyVO;
import com.yu.app.service.GoodsService;
import com.yu.common.constant.Const;
import com.yu.common.enums.GoodsPropertyCategory;
import com.yu.common.service.LockService;
import com.yu.common.service.cache.LocalCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsPropertyMapper goodsPropertyMapper;
    @Resource
    private LockService lockService;

    @Override
    public List<GoodsMenuVO> getGoodsMenuDetailList() {
        List<GoodsMenuVO> list = LocalCache.get(Const.CONST_goods_menu_vo_cache);
        if (!CollectionUtils.isEmpty(list))
            return list;

        // TODO 乐观锁 让一个请求去请求数据库 其他锁住, 锁10秒自动释放
        String version = UUID.randomUUID().toString();
        if (!lockService.tryLock(Const.CONST_lock_redis_prefix + Const.CONST_goods_menu_vo_cache, version, 10))
            return new ArrayList<>();

        try {
            List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.selectList(null);
            // 使用2个map去关联关系
            HashMap<String, List<Goods>> sameCategoryGoodsMap = new HashMap<>(goodsCategoryList.size());
            HashMap<String, GoodsMenuVO> goodsMenuVOMap = new HashMap<>(goodsCategoryList.size());
            for (GoodsCategory goodsCategory : goodsCategoryList) {
                sameCategoryGoodsMap.put(goodsCategory.getName(), new ArrayList<>());
                GoodsMenuVO goodsMenuVO = new GoodsMenuVO();
                goodsMenuVO.setGoodsCategoryName(goodsCategory.getName());
                goodsMenuVO.setGoodsCategoryName(goodsCategory.getName());
                goodsMenuVO.setDisplayOrder(goodsCategory.getDisplayOrder());
                goodsMenuVO.setGoodsCategoryShow(goodsCategory.getShowStatus());
                goodsMenuVOMap.put(goodsCategory.getName(), goodsMenuVO);
            }

            List<Goods> allGoods = goodsMapper.selectList(null);
            // 将所有商品分类
            for (Goods good : allGoods) {
                if (sameCategoryGoodsMap.containsKey(good.getGoodsCategoryName()))
                    sameCategoryGoodsMap.get(good.getGoodsCategoryName()).add(good);
            }

            // 关联同类商品排好序后放到到对应的类别里
            for (Map.Entry<String, GoodsMenuVO> goodsMenuVOEntry : goodsMenuVOMap.entrySet()) {
                List<Goods> sameCategoryGoodsList = sameCategoryGoodsMap.get(goodsMenuVOEntry.getKey());
                sameCategoryGoodsList.sort((o1, o2) -> o1.getDisplayOrder() - o2.getDisplayOrder());
                List<GoodsVO> goodsVos = new ArrayList<>();
                // 填充商品的属性
                for (Goods goods : sameCategoryGoodsList) {
                    List<GoodsProperty> goodsPropertyList = goodsPropertyMapper.selectList(
                            new QueryWrapper<GoodsProperty>().eq("goods_id", goods.getId()));
                    HashMap<String, List<GoodsProperty>> propertyMap = new HashMap<>();
                    for (GoodsProperty goodsProperty : goodsPropertyList) {
                        if (propertyMap.containsKey(goodsProperty.getCategory())) {
                            propertyMap.get(goodsProperty.getCategory()).add(goodsProperty);
                        } else {
                            propertyMap.put(goodsProperty.getCategory(), new ArrayList<GoodsProperty>() {{
                                add(goodsProperty);
                            }});
                        }
                        if (goodsProperty.getIsDefault() && GoodsPropertyCategory.ENUM_size.value.equals(goodsProperty.getCategory()))
                            goods.setDefaultPrice(goodsProperty.getRealPrice()); // 重新设置商品的默认价格
                    }
                    List<SameCategoryPropertyVO> goodsPropertyVos = new ArrayList<>();
                    for (Map.Entry<String, List<GoodsProperty>> entry : propertyMap.entrySet()) {
                        // 属性类别->属性列表  转换成对象
                        SameCategoryPropertyVO goodsPropertyVo = new SameCategoryPropertyVO();
                        goodsPropertyVo.setCategory(entry.getKey());
                        goodsPropertyVo.setRequired(!GoodsPropertyCategory.ENUM_jia_liao.value.equalsIgnoreCase(entry.getKey())); // 除了加料其他全部必选
                        goodsPropertyVo.setPropertyList(entry.getValue());
                        goodsPropertyVos.add(goodsPropertyVo);
                    }
                    GoodsVO goodsVo = new GoodsVO();
                    BeanUtils.copyProperties(goods, goodsVo);
                    goodsVo.setGoodsPropertyVos(goodsPropertyVos);
                    goodsVo.setRealPrice(goods.getDefaultPrice());
                    goodsVos.add(goodsVo);
                }
                goodsMenuVOEntry.getValue().setGoodsList(goodsVos);
            }

            List<GoodsMenuVO> goodsMenuVOList = new ArrayList<>(goodsMenuVOMap.values());
            // 最后对菜单进行排序
            goodsMenuVOList.sort((o1, o2) -> o1.getDisplayOrder() - o2.getDisplayOrder());

            log.info("缓存到java内存: " + goodsCategoryList);
            LocalCache.set(Const.CONST_goods_menu_vo_cache, goodsMenuVOList, Const.CONST_one_hour);
            return goodsMenuVOList;
        } finally {
            // TODO 保证是这个人释放的锁
            lockService.releaseLock(Const.CONST_lock_redis_prefix + Const.CONST_goods_menu_vo_cache, version);
        }
    }
}
