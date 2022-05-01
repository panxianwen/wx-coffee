package com.yu.admin.modules.app.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.yu.common.enums.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("订单")
@Data
@TableName("order_info")
public class OrderInfoAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单号")
    @TableId(type = IdType.INPUT)
    private String orderNo;

    private String wxOpenid;

    @ApiModelProperty("订单状态")
    private String orderStatus;

    @ApiModelProperty("微信支付系统生成的订单号")
    @TableField(exist = false)
    private String wxPayTransactionId;

    @ApiModelProperty("取餐方式")
    private String takeType;

    @ApiModelProperty("收货地址")
    private String addressDetail;

    @ApiModelProperty("大致商品,eg: 奶茶*2")
    private String goodsPreview;

    @ApiModelProperty("商品总数")
    private Integer goodsTotalNum;

    private Integer totalPrice;

    @ApiModelProperty("支付金额")
    private Integer payPrice;

    @ApiModelProperty("取单号，一般取手机尾号")
    private Integer verifyNum;

    @ApiModelProperty("备注")
    private String extraInfo;

    @ApiModelProperty("下单时间")
    private Date createTime;

//    @ApiModelProperty("微信支付时间")
//    private Date payTime;

    @ApiModelProperty("完成时间")
    private Date finishTime;

    @ApiModelProperty("用户联系电话")
    private String userPhone;

    @ApiModelProperty("取餐人")
    private String receiver;


}
