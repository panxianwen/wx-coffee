package com.yu.common.interceptor;


import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import com.yu.common.annotation.AccessLimiter;
import com.yu.common.util.ip.IpUtil;
import com.yu.common.util.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

// 限流拦截器
@Slf4j
@Component
public class LimiterInterceptor extends HandlerInterceptorAdapter {
    // 每个key的每秒可以访问N次 根据ip分配不同的令牌桶 每天自动清理
    private static LoadingCache<String, RateLimiter> rateLimiterCache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build(new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String key) {
                    return RateLimiter.create(5); // 新的key初始化，每秒发的令牌数
                }
            });

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ((handler instanceof HandlerMethod)) {
            AccessLimiter annotation = ((HandlerMethod) handler).getMethod().getAnnotation(AccessLimiter.class);
            if (annotation != null) {
                try {
                    // TODO 一些接口限流, 比如下单接口，支付接口
                    if (!rateLimiterCache.get(request.getServletPath()).tryAcquire()) {
                        renderResponse(response);
                        log.error("对接口进行限流处理: 访问的接口: " + request.getServletPath());
                        return false;
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

    private final static String CONST_response_json_str =
            JSON.toJSONString(JSON.toJSONString(R.fail("服务器频繁，请稍后重试...")));
    private void renderResponse(HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "application/json;charset=UTF-8 ");
        response.getWriter().print(CONST_response_json_str); // 手动直接给客户端传输信息
        response.flushBuffer();
    }
}
