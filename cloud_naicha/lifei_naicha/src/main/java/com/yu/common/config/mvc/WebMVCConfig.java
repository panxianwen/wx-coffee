package com.yu.common.config.mvc;

import com.yu.common.interceptor.AppApiInterceptor;
import com.yu.common.interceptor.LimiterInterceptor;
import com.yu.common.interceptor.SystemApiInterceptor;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer, ErrorPageRegistrar {
    @Resource
    private AppApiInterceptor appApiInterceptor;  // api拦截器
    @Resource
    private SystemApiInterceptor systemApiInterceptor; // 管理后台拦截器
    @Resource
    private LimiterInterceptor limiterInterceptor; // 限流拦截器


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(this.limiterInterceptor).addPathPatterns(("/**"));
        registry.addInterceptor(this.appApiInterceptor).addPathPatterns("/api-app/**");
        registry.addInterceptor(this.systemApiInterceptor).addPathPatterns(("/api-system/**"));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {  // 如果是Windows系统
            registry.addResourceHandler("/static/image/**").addResourceLocations("file:D:/image/");
        } else {  // linux 和mac
            registry.addResourceHandler("/static/image/**").addResourceLocations("file:/image/");
        }
    }

    // 处理404页面，或者将Vue页面打包放到静态资源下找不到页面的问题
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
    }
}
