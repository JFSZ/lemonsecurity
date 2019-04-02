package com.zzidc.service;

import com.zzidc.bean.RoleBean;
import com.zzidc.bean.UserBean;

import java.util.List;

/**
 * @ClassName UserServcie
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 11:27
 **/
public interface UserServcie {
    public UserBean getUserInfo(UserBean userBean);

    List<RoleBean> getRoleInfo(Integer id);
}
