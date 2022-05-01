package com.yu.admin.modules.app.pojo;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yu.common.enums.GoodsPropertyCategory;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("商品的具体属性")
@Data
@TableName("goods_property")
public class GoodsPropertyAdmin {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer goodsId;
    private String category; // '温度','甜度','大小','口味
    private String propertyOption; // 可选项，eg: 常温
    private Boolean isDefault; // 默认属性
    //private Integer rebasePrice; // 重置基础价格
    //private Integer extraPrice; // 额外价格
    private Integer realPrice; // 具体价格
}
