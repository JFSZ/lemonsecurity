package com.zzidc.service;

import com.zzidc.bean.RoleBean;
import com.zzidc.bean.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDetailService
 * @Author chenxue
 * @Description 自定义数据来源
 * @Date 2019/4/2 11:07
 **/
@Component
public class UserDetailService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserDetailService.class);
    @Autowired
    UserServcie servcie;
    /*
    * @Author chenxue
     * @Description //根据用户名查找用户信息,并封装在UserDetails中
     * @Date 2019/4/2 11:08
     * @Param [s]
     * @return org.springframework.security.core.userdetails.UserDetails
     **/
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ArrayList<SimpleGrantedAuthority> arrayList = new ArrayList<>();
        //数据库中读取用户信息 和 用户角色信息
        UserBean user = new UserBean();
        user.setUsername(s);
        UserBean userInfo = servcie.getUserInfo(user);
        System.out.println("用户名:" + userInfo.getUsername() +"用户密码:"+userInfo.getPassword());
        if(userInfo == null){
            throw new UsernameNotFoundException("username is not exist");
        }
        //查询用户角色信息
        List<RoleBean> roleBeanList = servcie.getRoleInfo(userInfo.getId());
        for (RoleBean roleBean : roleBeanList){
            arrayList.add(new SimpleGrantedAuthority(roleBean.getName()));
        }
        User user1 = new User(s,new BCryptPasswordEncoder().encode(userInfo.getPassword()), arrayList);
        return user1;
    }
}
