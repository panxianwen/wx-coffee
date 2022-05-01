package com.yu.common.config.property;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@ApiModel("小程序相关配置")
@Configuration
@Data
public class AppConfig {
    @ApiModelProperty("店铺名称")
    @Value("${my.properties.app.shopName}")
    private String shopName = "coffee小店";

    @ApiModelProperty("包装费(单位: 分)")
    @Value("${my.properties.app.packingPrice}")
    private int packingPrice = 0;

    @ApiModelProperty("外卖配送费(单位: 分)")
    @Value("${my.properties.app.sendingPrice}")
    private int sendingPrice = 1_00;

    // 起送需要的最低价格 单位: 分
    @ApiModelProperty("起送需要的最低价格")
    @Value("${my.properties.app.sendingNeedLeastPrice}")
    private int sendingNeedLeastPrice = 10_00;

    // 营业开始时间，整点
    @ApiModelProperty("营业开始时间, 整点(不要大于结束时间)")
    @Value("${my.properties.app.businessStartTime}")
    private int businessStartTime = 10;

    // 营业结束时间
    @ApiModelProperty("营业结束时间, 整点(不要小于开始时间)")
    @Value("${my.properties.app.businessEndTime}")
    private int businessEndTime = 22;

    @ApiModelProperty("联系电话1")
    @Value("${my.properties.app.lianxidianhua1}")
    private String lianxidianhua1;

     @ApiModelProperty("联系电话2")
    @Value("${my.properties.app.lianxidianhua2}")
    private String lianxidianhua2;

     @ApiModelProperty("联系QQ")
    @Value("${my.properties.app.lianxiQQ}")
    private String lianxiQQ;

    @ApiModelProperty("店铺开放状态, 商家休息|营业中")
    @Value("${my.properties.app.shopStatus}")
    private Boolean shopStatus = true;

    @ApiModelProperty("菜单上面的公告通知")
    @Value("${my.properties.app.shopNotice}")
    private String shopNotice;

    @ApiModelProperty("允许测试号登录")
    @Value("${my.properties.app.testUserLoginEnabled}")
    private Boolean testUserLoginEnabled;
}
