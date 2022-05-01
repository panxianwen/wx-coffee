package com.yu.app.pojo;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yu.common.enums.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel("订单")
@Data
public class OrderInfo {
    @TableId(type = IdType.INPUT)
    private String orderNo;
    private String wxOpenid;
    private String addressDetail;
    @ApiModelProperty("所有商品概览信息")
    private String goodsPreview;
    private Integer goodsTotalNum;
    private Integer totalPrice;
    private Integer payPrice;
    private String orderStatus;
    @ApiModelProperty("微信支付系统生成的订单号")
    @TableField(exist = false)
    private String wxPayTransactionId;
    @ApiModelProperty("取单号，一般取手机尾号")
    private Integer verifyNum;
    private String takeType;
    @ApiModelProperty("用户备注")
    private String extraInfo;
    private Date createTime;
//    @ApiModelProperty("支付时间")
//    private Date payTime;
    @ApiModelProperty("订单完成时间")
    private Date finishTime;
    private String userPhone;
    @ApiModelProperty("取餐人")
    private String receiver;
}
