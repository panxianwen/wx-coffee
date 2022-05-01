package com.yu.app.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yu.app.pojo.OrderInfo;
import com.yu.app.pojo.form.CreateOrderParams;
import com.yu.app.pojo.vo.HistoryOrderVO;
import com.yu.common.exception.ServiceException;

import java.util.List;

public interface OrderService {

    // 创建订单
    String createOrder(CreateOrderParams orderParams, String wxOpenid) throws ServiceException;

    // 微信小程序预先支付
    Object wxPrepay(String wxOpenid, String orderNo, String payIp) throws ServiceException;

    // 分页获取历史订单
    Page<HistoryOrderVO> getHistoryOrderByPage(Integer pageNo, Integer pageSize, String wxOpenid) throws ServiceException;

    // 获取订单详情
    OrderInfo getOrderDetail(String orderNo) throws ServiceException;

    // 取消订单
    Integer cancelOrder(String orderNo);

    // 完成订单
    Integer finishedOrder(String orderNo, String wxOpenid) throws ServiceException;

    // 处理中订单
    List<OrderInfo> getHandlingOrders(String wxOpenid) throws ServiceException;
}
