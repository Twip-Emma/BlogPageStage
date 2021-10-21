package com.example.blogpagestage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.blogpagestage.entity.User;
import com.example.blogpagestage.service.UserService;
import com.example.blogpagestage.tool.UserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserTool userTool;

    @Autowired
    UserService userService;

    @PostMapping("/goTo")
    public String userToLogin(@RequestBody String userData, HttpSession session){
        User user = JSONObject.parseObject(userData, User.class);
        if(!userTool.checkNewUser(user)){
            if(userTool.checkUserPass(user)){
                session.setAttribute("userinfo",user);
                return "密码正确，您已登录";
            }else {
                return "密码错误，请重新检查你的用户名或密码";
            }
        }else{
            return "该用户未被注册，请重试";
        }
    }

    @PostMapping("/isLogin")
    public String getUserData(HttpServletRequest request, HttpServletResponse response){
        User userInfo = userService.getUserInfo(request);
        if(userInfo != null) {
            System.out.println(userInfo);
            String userData = JSON.toJSONString(userInfo);
            return userData;
        }else {
            return "请先登录";
        }
    }
}
