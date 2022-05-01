package com.yu.app.service;



import com.yu.app.pojo.vo.GoodsMenuVO;

import java.util.List;

public interface GoodsService {

    // 获取要显示的商品菜单列表  List<GoodsMenuVO>
    public List<GoodsMenuVO>  getGoodsMenuDetailList();

}
