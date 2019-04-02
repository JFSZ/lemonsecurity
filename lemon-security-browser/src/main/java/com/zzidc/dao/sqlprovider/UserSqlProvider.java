package com.zzidc.dao.sqlprovider;

import com.zzidc.bean.UserBean;

/**
 * @ClassName UserProvider
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 11:36
 **/
public class UserSqlProvider {
    public String getUserInfoSql(UserBean userBean){
        StringBuilder sql = new StringBuilder("select * from user where ");
        if(userBean.getId() != null) {
            sql.append("id = #{id}");
        } else {
            sql.append("username = #{username}");
        }
        return sql.toString();
    }
}
