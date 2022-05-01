package com.yu.app.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel("商品菜单")
@Data
public class GoodsMenuVO {
    private Byte displayOrder; // 显示顺序
    private String goodsCategoryName;
    private Boolean goodsCategoryShow; // 是否显示该类商品

    private List<GoodsVO> goodsList;

}
