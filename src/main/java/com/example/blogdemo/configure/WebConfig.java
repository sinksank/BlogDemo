package com.example.blogdemo.configure;

import com.example.blogdemo.interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration=registry.addInterceptor(new loginInterceptor());
        registration.excludePathPatterns(
                "/login.html",
                "/register.html",
                "/css/**",
                "/font/css",
                "/img/css",
                "/user/**"
        );
    }
}
