package com.yu.admin.modules.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yu.admin.modules.app.pojo.OrderInfoAdmin;
import com.yu.common.enums.OrderStatus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public interface OrderInfoAdminMapper extends BaseMapper<OrderInfoAdmin> {

    // 更新订单状态和微信交易号
    @Update("UPDATE order_info SET order_status = #{param3}, " +
            " wx_pay_transaction_id = #{param2}, pay_price=#{param4} \n" +
            "WHERE order_no = #{param1}; ")
    void updateOrderStatus(String orderNo, String wxPayTransactionId, String orderStatus, Integer payPrice);

    // 通过微信交易号查找微信订单号
    @Select("SELECT order_no FROM order_info where wx_pay_transaction_id is null order by create_time limit #{param1}; ")
    List<String> selectOrderNoByWxPayTransactionId(int limit);


    // 删除没有支付的订单
    @Delete("delete from order_info where order_status = #{param1} or wx_pay_transaction_id is null; ")
    void deleteOrderNotPay(String orderStatus);
}
