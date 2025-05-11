package com.wind.perfmonitor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wind.perfmonitor.interceptor.FakeLoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private FakeLoginInterceptor fakeLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(fakeLoginInterceptor)
                .addPathPatterns("/**"); // 只拦截你需要的接口
    }
}
