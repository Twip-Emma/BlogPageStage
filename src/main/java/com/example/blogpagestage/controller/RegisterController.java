package com.example.blogpagestage.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.blogpagestage.entity.User;
import com.example.blogpagestage.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequestMapping("/register")
@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/newUser")
    public String creatNewUser(HttpServletRequest request, HttpServletResponse response, @RequestBody String userData) {
        User user = JSONObject.parseObject(userData, User.class);
        if (user.getUserCard().equals("") || user.getUserName().equals("") || user.getUserPass().equals("")) {
            System.out.println("信息不完全");
            return "参数缺失";
        } else {
            Boolean re = registerService.CreatNewUser(user);
            if (re) {
                System.out.println("创建完成");
            }else{
                return "重复的用户";
            }
        }
        String re = "处理完毕";
        return re;
    }
}
