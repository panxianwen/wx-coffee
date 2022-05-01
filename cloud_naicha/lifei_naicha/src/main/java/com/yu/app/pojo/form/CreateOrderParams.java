package com.yu.app.pojo.form;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yu.app.pojo.vo.GoodsVO;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;
import java.util.List;

// 下单参数对象
@Data
public class CreateOrderParams {
    private String wxOpenid;
    private String addressDetail;
    private Integer totalPrice;
    private Integer verifyNum; // 取单号，一般取手机尾号
    private String takeType;
    private String extraInfo;
    private String userPhone;
    @ApiModelProperty("取餐人")
    private String receiver;
    private String goodsPreview;
    private Integer goodsTotalNum;
}
