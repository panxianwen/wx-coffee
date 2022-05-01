package com.yu.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("商品类别")
@Data
public class GoodsCategory {
    @TableId(type = IdType.INPUT)
    private String name;
    @ApiModelProperty("显示的顺序")
    private Byte displayOrder;
    private Boolean showStatus;
}
