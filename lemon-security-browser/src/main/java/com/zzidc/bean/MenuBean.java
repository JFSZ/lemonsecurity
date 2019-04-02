package com.zzidc.bean;

import lombok.Data;

/**
 * @ClassName MenuBeab
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 15:05
 **/
@Data
public class MenuBean {
    private Integer id;
    private String name;
    private String menuType;
    private String menuUrl;
    private String descn;

    public MenuBean(){

    }

    public MenuBean(String name, String menuType, String menuUrl, String descn) {
        this.name = name;
        this.menuType = menuType;
        this.menuUrl = menuUrl;
        this.descn = descn;
    }
}
