package com.soft.controller;

import com.soft.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(value = "http://127.0.0.1:8020",maxAge = 2000)
public class AjaxController {
    @RequestMapping("/hello1")
    @ResponseBody
    public List hello1(){
        System.out.println("进入后台方法------");
//        System.out.println("hello = "+hello);
        List list = new ArrayList<>();
        list.add("郭豪");
        list.add("张峻旗");
        list.add("刘世玉");
        list.add("肖战");
        list.add("蓝湛");
        return list;
    }

    @RequestMapping("/login")
    @ResponseBody
    public User login(){
      User user  = new User("admin","123456");
        return user;
    }


}
