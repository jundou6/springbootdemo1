package com.offcn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  //配置类
public class WebMvcConfig implements WebMvcConfigurer {
    // 添加资源的属性路径
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/abc/**").addResourceLocations("file:D:\\chart\\");
    }
}
