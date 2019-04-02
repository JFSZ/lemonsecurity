package com.zzidc.bean;

import lombok.Data;

/**
 * @ClassName RoleBean
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 15:04
 **/
@Data
public class RoleBean {
    private Integer id;
    private String name;
    private String descn;
    public RoleBean(){

    }

    public RoleBean(String name, String descn) {
        this.name = name;
        this.descn = descn;
    }
}
