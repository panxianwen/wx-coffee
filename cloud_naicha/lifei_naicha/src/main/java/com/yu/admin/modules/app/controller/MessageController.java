package com.yu.admin.modules.app.controller;

import com.yu.admin.modules.app.mapper.OrderInfoAdminMapper;
import com.yu.admin.modules.app.mapper.OrderRefundMapper;
import com.yu.admin.modules.app.pojo.dto.RecentOrderMessage;
import com.yu.common.annotation.AccessLimiter;
import com.yu.common.annotation.NeedPermission;
import com.yu.common.service.WeixinPayService;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Api(tags = "系统：消息服务")
@RestController
@RequestMapping("/api-system/message")
public class MessageController {

    // 最新的订单消息
    private LinkedList<RecentOrderMessage> recentOrderMessageList = new LinkedList<RecentOrderMessage>();

    @ApiOperation("查询最新的订单消息")
    @AccessLimiter
    @GetMapping("/resentOrderMessage")
    public R<List<RecentOrderMessage>> getResentOrderMessage() {
        return R.ok(recentOrderMessageList);
    }

    @ApiOperation("确认收到消息")
    @DeleteMapping("/confirmReceiveOrderMessage/{orderNo}")
    public R<String> confirmReceiveOrderMessage(@PathVariable String orderNo) {
        Iterator<RecentOrderMessage> iterator = recentOrderMessageList.iterator();
        while (iterator.hasNext()) {
            RecentOrderMessage message = iterator.next();
            if (message.getOrderNo().equalsIgnoreCase(orderNo)) {
                iterator.remove();
                return R.ok("已确认收到");
            }
        }
        return R.ok("已经确认过了");
    }

    // 添加最新订单消息
    public void addOrderMessage(RecentOrderMessage message) {
        if (recentOrderMessageList.size() >= 10) {
            recentOrderMessageList.removeFirst();
        }
        recentOrderMessageList.add(message);
    }

}
