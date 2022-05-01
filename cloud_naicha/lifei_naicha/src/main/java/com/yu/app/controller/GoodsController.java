package com.yu.app.controller;

import com.yu.app.pojo.vo.GoodsMenuVO;
import com.yu.app.service.impl.GoodsServiceImpl;
import com.yu.common.annotation.AccessLimiter;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品服务")
@RestController
@RequestMapping("/api-app/goods")
public class GoodsController {
    @Resource
    private GoodsServiceImpl goodsService;

    @AccessLimiter
    @ApiOperation("获取要显示的商品菜单列表")
    @GetMapping("/goodsMenu/list")
    public R<List<GoodsMenuVO>> getGoodsMenuDetailList() {
        return R.ok(goodsService.getGoodsMenuDetailList());
    }

}

