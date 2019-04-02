package com.zzidc.dao;

import com.zzidc.bean.UserBean;
import com.zzidc.dao.sqlprovider.UserSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @ClassName UserMapper
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 11:32
 **/
@Mapper
public interface UserMapper {
    @SelectProvider(type = UserSqlProvider.class,method = "getUserInfoSql")
    @Results(id = "userInfoMap",value = {
            @Result(property = "id",column = "id",id = true),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "status",column = "status"),
            @Result(property = "descn",column = "descn")
    })
    public UserBean getUserInfo(UserBean userBean);
}
