package com.yu.admin.modules.system.controller;

import com.yu.common.annotation.NeedPermission;
import com.yu.common.config.property.AppConfig;
import com.yu.common.constant.Const;
import com.yu.common.exception.ServiceException;
import com.yu.common.service.cache.LocalCache;
import com.yu.common.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "系统：小程序配置")
@RestController
@RequestMapping("/api-system/config")
public class AppConfigController {
    @Resource
    private AppConfig appConfig;

    @ApiOperation("获取小程序的所有配置")
    @GetMapping
    public R<AppConfig> getAppConfig() {
        return R.ok(getAppConfigFromMemory());
    }

    // 从内存里获取小程序的配置信息
    public AppConfig getAppConfigFromMemory() {
        Object o = LocalCache.get(Const.CONST_app_config);
        if (o != null)
            return (AppConfig) o;
        else {
            AppConfig config = new AppConfig();
            BeanUtils.copyProperties(appConfig, config); // 不要使用appConfig（它是个代理对象）
            LocalCache.set(Const.CONST_app_config, config);
            return config;
        }
    }

    @ApiOperation("修改配置信息")
    @NeedPermission("system:config:update")
    @PutMapping
    public R<AppConfig> updateAppConfig(@RequestBody AppConfig updateConfig) throws ServiceException {
        if (updateConfig.getBusinessStartTime() < 0 || updateConfig.getBusinessStartTime() > 24
                || updateConfig.getBusinessEndTime() < 0 || updateConfig.getBusinessEndTime() > 24)
            throw new ServiceException("营业开始时间或结束时间不合法, 只能为0到24的整数");
        if (updateConfig.getBusinessStartTime() >= updateConfig.getBusinessEndTime())
            throw new ServiceException("请将营业开始时间设置在营业结束时间之前, [开始时间, 结束时间)");

        BeanUtils.copyProperties(updateConfig, appConfig);
        LocalCache.del(Const.CONST_app_config);
        return getAppConfig(); // 立马刷新缓存
    }

}
