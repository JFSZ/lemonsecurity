package com.zzidc.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WebConfig
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/1 9:16
 **/
@Configuration
public class WebConfig{
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        MyFilter filter = new MyFilter();
        filterRegistrationBean.setFilter(filter);
        List<String> urls = new ArrayList<>();
        urls.add("/hello");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }
}
