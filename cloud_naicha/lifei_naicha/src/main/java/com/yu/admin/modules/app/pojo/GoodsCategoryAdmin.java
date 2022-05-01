package com.yu.admin.modules.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("商品类别")
@Data
@TableName("goods_category")
public class GoodsCategoryAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

    @TableId(type = IdType.INPUT)
    private String name;

    @ApiModelProperty("显示顺序")
    private Integer displayOrder;

    @ApiModelProperty("是否显示")
    private Boolean showStatus;

}
