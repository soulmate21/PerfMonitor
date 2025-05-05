package com.wind.perfmonitor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCorsConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 匹配所有路径
                .allowedOrigins("http://localhost:5173")  // Vue 前端地址,允许跨域访问
                .allowedMethods("*")  //允许所有 HTTP 方法
                .allowedHeaders() // 允许所有请求头
                .allowCredentials(true); // 允许携带 Cookie
    }
}
