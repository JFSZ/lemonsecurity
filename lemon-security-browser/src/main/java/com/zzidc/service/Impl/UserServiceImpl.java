package com.zzidc.service.Impl;

import com.zzidc.bean.RoleBean;
import com.zzidc.bean.UserBean;
import com.zzidc.dao.RoleMapper;
import com.zzidc.dao.UserMapper;
import com.zzidc.service.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 11:28
 **/
@Service
public class UserServiceImpl implements UserServcie {
    @Autowired
    UserMapper mapper;
    @Autowired
    RoleMapper userRoleMapper;
    @Override
    public UserBean getUserInfo(UserBean userBean) {
        return mapper.getUserInfo(userBean);
    }

    @Override
    public List<RoleBean> getRoleInfo(Integer id) {
        return userRoleMapper.getRoleInfo(id);
    }
}
