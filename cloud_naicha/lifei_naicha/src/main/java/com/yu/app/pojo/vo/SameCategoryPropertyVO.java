package com.yu.app.pojo.vo;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.yu.app.pojo.GoodsProperty;
import com.yu.common.enums.GoodsPropertyCategory;
import lombok.Data;

import java.util.List;

// 同一类别的属性
@Data
public class SameCategoryPropertyVO {
    private String category;
    private Boolean required;
    private List<GoodsProperty> propertyList;
}
