package com.zzidc.bean;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName UserBean
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 11:20
 **/
@Data
public class UserBean {
    @NotEmpty(message = "id不可为空")
    private Integer id;
    @NotEmpty(message = "用户名不可为空")
    private String username;
    @NotEmpty(message = "密码不可为空")
    private String password;
    private Integer status;
    private String descn;

    public UserBean(){

    }
    public UserBean(String username, String password, Integer status, String descn) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.descn = descn;
    }
}
