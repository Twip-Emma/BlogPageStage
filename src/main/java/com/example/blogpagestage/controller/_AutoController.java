package com.example.blogpagestage.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.blogpagestage.entity.ArticleInfo;
import com.example.blogpagestage.entity.User;
import com.example.blogpagestage.tool.UserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/tool", produces = "application/json;charset=UTF-8")
public class _AutoController {
    @Autowired
    UserTool userTool;

    @PostMapping("/findUserName")
    public String getUserAllArticle(@RequestBody String userId){
        User user = JSONObject.parseObject(userId, User.class);
        User re = userTool.findUserByUserId(user.getUserId());
//        System.out.println(re.getUserName());
        return re.getUserName();
    }
}
