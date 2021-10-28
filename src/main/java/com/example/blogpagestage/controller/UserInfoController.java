package com.example.blogpagestage.controller;

import com.example.blogpagestage.entity.ArticleInfo;
import com.example.blogpagestage.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/userInfo", produces = "application/json;charset=UTF-8")
public class UserInfoController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/getUserAllArticle")
    public List<ArticleInfo> getUserAllArticle(HttpServletRequest request){
        List<ArticleInfo> userAllArticle = articleService.getUserAllArticle(request);
        return userAllArticle;
    }
}
