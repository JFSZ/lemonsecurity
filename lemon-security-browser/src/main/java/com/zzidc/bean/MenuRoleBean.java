package com.zzidc.bean;

import lombok.Data;

/**
 * @ClassName MenuRoleBean
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 15:12
 **/
@Data
public class MenuRoleBean {
    private Integer menuId;
    private Integer roleId;
    public MenuRoleBean(){

    }

    public MenuRoleBean(Integer menuId, Integer roleId) {
        this.menuId = menuId;
        this.roleId = roleId;
    }
}
