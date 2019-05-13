package com.blog.myblog.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @description 拦截器注册
 * @author dongyang
 * @date 2019/05/13
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private BaseInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置拦截器拦截路径,排除 static下面的静态资源以及登录页面
        String[] excludes = {"/js/**","/css/**","/common/**","/images/**"};
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(excludes);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }
}
