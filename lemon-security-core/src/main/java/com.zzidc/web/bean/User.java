package com.zzidc.web.bean;

import com.fasterxml.jackson.annotation.JsonView;
import com.zzidc.web.validator.IsIdCard;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @ClassName User
 * @Author chenxue
 * @Description TODO
 * @Date 2019/3/29 11:33
 **/
public class User {
    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @Past(message = "生日必须为过去的日期")
    private Date birthday;
    @IsIdCard(message = "身份证必须为大陆的18位或者15位，或者是港澳的10位")
    private String idCard;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
