package com.yu.admin.modules.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("")
@Data
@TableName("goods")
public class GoodsAdmin implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String goodsCategoryName;

    private String name;

    @ApiModelProperty("显示次序")
    private Integer displayOrder;

    @ApiModelProperty("默认价格")
    private Integer defaultPrice;

    @ApiModelProperty("是否在卖")
    private Boolean isSell;

    @ApiModelProperty("商品图片")
    private String image;

    @ApiModelProperty("描述")
    private String description;

    // ********* 非数据库表字段 ********** //
    @ApiModelProperty("商品的属性列表")
    @TableField(exist = false)
    private List<GoodsPropertyAdmin> goodsPropertyList;

}
