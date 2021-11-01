package com.example.blogpagestage.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.blogpagestage.entity.ArticleInfo;
import com.example.blogpagestage.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/article", produces = "application/json;charset=UTF-8")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/newArticle")
    public String newArticle(@RequestBody String articleData, HttpServletRequest request){
        ArticleInfo articleInfo = JSONObject.parseObject(articleData, ArticleInfo.class);
        articleService.createNewArticle(articleInfo,request);
        return "ok?";
    }

    @PostMapping("/getUserAllArticle")
    public List<ArticleInfo> getUserAllArticle(HttpServletRequest request){
        List<ArticleInfo> userAllArticle = articleService.getUserAllArticle(request);
        return userAllArticle;
    }

    @PostMapping("/getAllComment")
    public String getAllComment(@RequestBody String articleId, HttpServletRequest request){
//        ArticleInfo articleInfo = JSONObject.parseObject(articleData, ArticleInfo.class);
//        articleService.createNewArticle(articleInfo,request);
        System.out.println(articleId);
        return "ok2?";
    }
}
