package com.soft.controller;

import com.soft.entity.User;
import com.soft.service.UserSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
//后台处理跨域的方式
@CrossOrigin(value = "http://127.0.0.1:8020",maxAge = 2000)
public class UserController {
    @Autowired
    UserSevices userSevices;
    @RequestMapping("/queryAllUser")
//    @RequestMapping(value="/queryAllUser",method = RequestMethod.POST)
    @ResponseBody
    public List<User>  queryAllUser(){
        List<User> userList = userSevices.selectAllUser();
        System.out.println(userList);
        return userList;
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(String userName,String pwd,String email){
        System.out.println("userName="+userName+";pwd="+pwd+";email="+email);
        User user = new User(userName, pwd, email);
        int s = userSevices.insertUser(user);
        String msg = "";
        if(s>0){
            return msg="添加成功";
        }else{
            return msg="添加失败";
        }
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public String  updateUser(String id,String  userName,String pwd,String email){
        System.out.println("id="+id+"--name="+userName);
        int realId = Integer.parseInt(id);
        User user = new User(realId,userName,pwd,email);
        int i = userSevices.updateUser(user);
        String message = "";
        if(i>0){
            return message="修改成功";
        }else{
            return message="修改失败";
        }
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(String id){
        int realId = Integer.parseInt(id);
        System.out.println("realId="+realId);
        boolean b = userSevices.deleteById(realId);
        String message = "";
        if(b){
            return message="删除成功";
        }else{
            return message="删除失败";
        }
    }

}
