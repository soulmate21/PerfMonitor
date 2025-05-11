package com.wind.perfmonitor.interceptor;

import com.wind.perfmonitor.Repository.UserRepository;
import com.wind.perfmonitor.entity.User;

import context.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//配置请求用户，前期原型使用

@Component
public class FakeLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 查询 wind 用户
        User user = userRepository.findByUsername("wind");
        if (user == null) {
            throw new RuntimeException("请先在数据库中插入用户名为 'wind' 的用户");
        }
        UserContext.setUser(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserContext.clear(); // 清理线程变量，防止内存泄露
    }
}
