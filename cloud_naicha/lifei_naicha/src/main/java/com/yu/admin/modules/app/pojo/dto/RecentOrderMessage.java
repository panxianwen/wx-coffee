package com.yu.admin.modules.app.pojo.dto;

import lombok.Data;

import java.util.Date;

// 最新的订单消息
@Data
public class RecentOrderMessage {
    private String orderNo;
    private String address;
}
