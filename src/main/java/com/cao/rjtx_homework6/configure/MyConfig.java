package com.cao.rjtx_homework6.configure;

import lombok.experimental.Delegate;
import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



    //@Deprecated
    @Configuration
    public class MyConfig implements WebMvcConfigurer {

        @Bean
        public AddHandlerInterceptor getAddHandlerInterceptor(){
            return new AddHandlerInterceptor();
        }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAddHandlerInterceptor()).addPathPatterns("/insert");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/add").setViewName("add");

    }
}
