package com.yu.admin.modules.timing;

import com.yu.common.annotation.NeedPermission;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

// 执行定时任务
@Api(tags = "系统: 定时任务")
@RestController
@RequestMapping("/api-system/timingTask")
public class TimingTaskController {
    @Resource
    private TimingTaskRunner timingTaskRunner;

    @ApiOperation("执行一次定时任务")
    @NeedPermission
    @GetMapping("/execute/{taskMethodName}")
    public R<String> checkGoodsProperty(@PathVariable String taskMethodName) {
        if ("resetGoodsDefaultProperty".equalsIgnoreCase(taskMethodName)) {
            timingTaskRunner.resetGoodsDefaultProperty();
        } else if ("updateGoodsMenuListRedisCache".equalsIgnoreCase(taskMethodName)) {
            timingTaskRunner.updateGoodsMenuListRedisCache();
        } else return R.fail("没有该任务: " + taskMethodName);

        return R.ok("执行成功");
    }


}
