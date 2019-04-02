package com.zzidc.dao;

import com.zzidc.bean.RoleBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName UserRoleMapper
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 15:31
 **/
@Mapper
public interface RoleMapper {
    @Select("select name from role where id = #{userId}")
    @Results({
            @Result(property = "id",column = "id",
            many = @Many(select = "com.zzidc.dao.UserRoleMapper.getUserRoleInfo")),
            @Result(property = "name",column = "name"),
            @Result(property = "descn",column = "descn")
    })
    public List<RoleBean> getRoleInfo(Integer userId);
}
