package com.china.framework.conf.login;

import com.china.framework.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 登陆拦截器的配置类
 * Liz 2020-12-1
 * */
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginHandlerInterceptor loginInterceptor = new LoginHandlerInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);

        // 拦截路径
        loginRegistry.addPathPatterns("/**");

        // 排除路径
        loginRegistry.excludePathPatterns(
                "/",
                "/error",
                "/login",
                "/register",
                "/loginPage",
                "/logout",
                "/error/*",
                "/css/login.css",
                "/favicon.ico",
                "/img/error/**",
                "/img/btn/**",
                "/img/login/**"
        );
    }

}
