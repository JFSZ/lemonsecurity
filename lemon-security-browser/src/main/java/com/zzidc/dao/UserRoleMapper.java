package com.zzidc.dao;

import com.zzidc.bean.UserRoleBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName UserRoleMapper
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 16:06
 **/
@Mapper
public interface UserRoleMapper {
    @Select("select user_id,role_id from user_role where user_id = #{userId}")
    @Results({
            @Result(property = "userId",column = "user_id")
    })
    public UserRoleBean getUserRoleInfo();
}
