package com.zzidc.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName BrowserSecurityConfig
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 10:50
 **/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{
    private SecurityProperties properties;
    private UserAuthenticationSuccessHandler userAuthenticationSuccessHandler;
    private UserFailureHander userFailureHander;

    /*
    * @Author chenxue
     * @Description //配置了这个Bean以后，从前端传递过来的密码将被加密
     * @Date 2019/4/2 17:16
     * @Param []
     * @return org.springframework.security.crypto.password.PasswordEncoder
     **/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/index")
                /*.successHandler(userAuthenticationSuccessHandler)
                .failureHandler(userFailureHander)*/
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest()
                .authenticated();
    }
}
