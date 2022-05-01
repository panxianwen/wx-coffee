package com.yu.admin.modules.timing;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.yu.admin.modules.app.mapper.OrderInfoAdminMapper;
import com.yu.admin.modules.app.service.OrderInfoAdminService;
import com.yu.admin.modules.system.controller.AppConfigController;
import com.yu.app.mapper.GoodsMapper;
import com.yu.app.mapper.GoodsPropertyMapper;
import com.yu.app.pojo.Goods;
import com.yu.app.pojo.GoodsCategory;
import com.yu.app.pojo.GoodsProperty;
import com.yu.app.service.impl.GoodsServiceImpl;
import com.yu.common.constant.Const;
import com.yu.common.enums.GoodsPropertyCategory;
import com.yu.common.enums.OrderStatus;
import com.yu.common.service.cache.LocalCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务
 */
@EnableScheduling
@Slf4j
@Component
public class TimingTaskRunner {
    @Resource
    private GoodsServiceImpl goodsService;
    @Resource
    private OrderInfoAdminMapper orderInfoAdminMapper;
    @Resource
    private AppConfigController appConfigController;
    @Resource
    private OrderInfoAdminService orderInfoAdminService;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsPropertyMapper goodsPropertyMapper;


    // TODO 定时更新小程序的商品菜单列表缓存
    @Scheduled(fixedDelay = 60 * 60 * 1000) // 1小时刷新一次
    public void updateGoodsMenuListRedisCache() {
        log.info("[定时任务] 定时更新小程序的商品菜单列表缓存");
        LocalCache.del(Const.CONST_goods_menu_vo_cache);
        goodsService.getGoodsMenuDetailList();
    }

    // TODO 重置所有商品的默认属性和默认价格
    @Transactional(rollbackFor = Exception.class)
    public void resetGoodsDefaultProperty() {
        log.info("重置所有商品的默认属性和默认价格");
        goodsPropertyMapper.resetIsDefault(); // 全部重置
        List<Goods> goodsList = goodsMapper.selectList(null);
        for (Goods goods : goodsList) {
            // 重置默认价格和默认选择的大小
            resetGoodsDefaultPropertyHelper(GoodsPropertyCategory.ENUM_size.value, goods);
            resetGoodsDefaultPropertyHelper(GoodsPropertyCategory.ENUM_temperature.value, goods);
            resetGoodsDefaultPropertyHelper(GoodsPropertyCategory.ENUM_tian_du.value, goods);
            resetGoodsDefaultPropertyHelper(GoodsPropertyCategory.ENUM_kou_wei.value, goods);
        }
        updateGoodsMenuListRedisCache();
    }

    // 重置默认的必选属性
    private void resetGoodsDefaultPropertyHelper(String propertyCategory, Goods goods) {
        List<GoodsProperty> properties = goodsPropertyMapper.selectList(
                new QueryWrapper<GoodsProperty>().eq("goods_id", goods.getId())
                .eq("category", propertyCategory)
        );
        if (properties != null && properties.size() >= 1) {
            // 随便设置一个默认的属性
            GoodsProperty goodsProperty = properties.get(0);
            goodsProperty.setIsDefault(true);
            goodsPropertyMapper.updateById(goodsProperty);

            if (GoodsPropertyCategory.ENUM_size.value.equalsIgnoreCase(propertyCategory)) {  // 大小属性就要重置商品的默认价格
                goods.setDefaultPrice(goodsProperty.getRealPrice());
                goodsMapper.updateById(goods);
            }
        }
    }

    // TODO 每天再次同步没有回调成功的订单交易号，有些已经付款了，但是回调失败了，主动去查
    @Scheduled(cron = "0 0 1 * * ? ") //
    public void recheckWxPayTransactionId() {
        log.info("[timing task] 再次同步没有回调成功的订单交易号，有些已经付款了，但是回调失败了，主动去查");
        List<String> orderNoList = orderInfoAdminMapper.selectOrderNoByWxPayTransactionId(10);
        for (String orderNo : orderNoList) {
            try {
                orderInfoAdminService.queryWeixinOrder(orderNo);
            } catch (WxPayException e) {
                e.printStackTrace();
            }
        }

        // 删除所有未支付的订单(未支付或没有微信交易号)
        orderInfoAdminMapper.deleteOrderNotPay(OrderStatus.ENUM_has_not_pay_money.value);
    }
}
