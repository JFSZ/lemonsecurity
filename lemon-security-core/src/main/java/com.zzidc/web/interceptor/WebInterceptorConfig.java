package com.zzidc.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebConfig
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/1 9:28
 **/
@Configuration
public class WebInterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private MyInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptor);
    }

}
