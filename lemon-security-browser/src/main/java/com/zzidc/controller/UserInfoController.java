package com.zzidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/2 17:43
 **/
@Controller
public class UserInfoController {
    @RequestMapping(value = "/login")
    public String login(){

        return "login";
    }
    @RequestMapping(value = "/index")
    public String index(){
        System.out.println("index页面");
        return "index";
    }
}
