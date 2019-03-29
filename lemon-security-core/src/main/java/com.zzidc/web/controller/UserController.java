package com.zzidc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.zzidc.web.bean.User;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Author chenxue
 * @Description TODO
 * @Date 2019/3/29 11:35
 **/
@RestController
public class UserController {
    /*
    * @Author chenxue
     * @Description //练习RESTful接口开发
     * @Date 2019/3/29 15:06
     * @Param []
     * @return java.util.List<com.zzidc.web.bean.User>
     **/
    @RequestMapping(value = "/user1",method = RequestMethod.GET)
    public List<User> query1(){
        return generateUsers();
    }

    @GetMapping("/user2")
    public List<User> query2(@RequestParam String username){
        System.out.println(username);
        return generateUsers();
    }

    @GetMapping("/user3/{username}")
    public List<User> query3(@PathVariable String username){
        System.out.println(username);
        return generateUsers();
    }

    @GetMapping("/user4")
    public List<User> query4(@PageableDefault(page = 1,size = 2,sort = "username") Pageable pageable){
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());
        return generateUsers();
    }
    /*
    * @Author chenxue
     * @Description // 测试 @PathVariable 注释
     * @Date 2019/3/29 15:04
     * @Param [id]
     * @return com.zzidc.web.bean.User
     **/
    @GetMapping("/getInfo/{id:\\d+}")
    public User getInfo(@PathVariable String id){
        System.out.println("查询用户的id为:" .concat(id));
        //模拟 查询用户
        User user = new User();
        user.setUsername("Tom");
        return user;
    }
    /*
    * @Author chenxue
     * @Description  测试 @JsonView 注解使用方法
     * @Date 2019/3/29 15:54
     * @Param []
     * @return com.zzidc.web.bean.User
     **/
    @GetMapping("/getSimpleUser")
    @JsonView(User.UserSimpleView.class)
    public User getSimpleView(){
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123456");
        return user;
    }

    @GetMapping("/getDetailUser")
    @JsonView(User.UserDetailView.class)
    public User getDetailView(){
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123456");
        return user;
    }

    /*
    * @Author chenxue
     * @Description 测试 @ReqeustBody 注解 将json 转换为User对象
     * @Date 2019/3/29 15:54
     * @Param [user]
     * @return com.zzidc.web.bean.User
     **/
    @PostMapping("/user1")
    public User create1(@RequestBody User user){
        System.out.println(ReflectionToStringBuilder.reflectionToString(user, ToStringStyle.MULTI_LINE_STYLE));
        user.setId(1);
        return user;
    }

    /*
    * @Author chenxue
     * @Description  测试 @Valid @RequestBody 注解 需要在实体类上加上 @NotEmpty 注解，
     * BindingResult bindingResult 存储校验错误信息
     * @Date 2019/3/29 15:55
     * @Param [user, bindingResult]
     * @return com.zzidc.web.bean.User
     **/
    @PostMapping
    public User create2(@Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(error ->System.out.println(error.getDefaultMessage()));
        }
        System.out.println(ReflectionToStringBuilder.reflectionToString(user, ToStringStyle.MULTI_LINE_STYLE));
        user.setId(2);
        return user;
    }

    /*
    * @Author chenxue
     * @Description 测试 Delete 请求方式
     * @Date 2019/3/29 16:11
     * @Param [id]
     * @return void
     **/
    @DeleteMapping("/user/{id:\\d+}")
    public void delete(@PathVariable Integer id){
        System.out.println("模拟删除用户,删除用户id为:".concat(String.valueOf(id)));
    }

    @PutMapping("/user/{id:\\d+}")
    public User update(@PathVariable Integer id){
        System.out.println("模拟修改用户操作");
        User user = new User();
        user.setId(id);
        user.setUsername("Tom");
        return user;
    }

    @GetMapping("/demo")
    @ResponseBody
    public User test(){
        throw new RuntimeException("测试");
    }
    private List<User> generateUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

}
