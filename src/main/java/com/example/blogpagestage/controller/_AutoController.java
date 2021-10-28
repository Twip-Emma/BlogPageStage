package com.example.blogpagestage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class _AutoController {
//    @RequestMapping("/")
//    public String _start(){
//        return null;
//    }

    //将当前登录状态返回给前端
    @RequestMapping("/returnLoginType")
    public String userLoginType(HttpServletRequest request){
        if((boolean)request.getSession().getAttribute("logintype")){
            return "true";
        }else {
            return "false";
        }
    }
}
