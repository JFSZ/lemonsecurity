package com.zzidc.bean;

import lombok.Data;

/**
 * @ClassName UserRoleBean
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 15:08
 **/
@Data
public class UserRoleBean {
    private Integer userId;
    private Integer roleId;
    public UserRoleBean(){

    }

    public UserRoleBean(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
