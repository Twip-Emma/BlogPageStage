package com.example.blogpagestage.service;

import com.example.blogpagestage.dao.ArticleCommentDao;
import com.example.blogpagestage.dao.ArticleInfoDao;
import com.example.blogpagestage.dao.UserDao;
import com.example.blogpagestage.entity.ArticleComment;
import com.example.blogpagestage.entity.ArticleInfo;
import com.example.blogpagestage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Component
public class ArticleService {
    @Autowired
    ArticleInfoDao articleInfoDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ArticleCommentDao articleCommentDao;

    public Boolean createNewArticle(ArticleInfo articleInfo, HttpServletRequest request){
        System.out.println(articleInfo);
        User user = (User)request.getSession().getAttribute("userinfo");
        User userRe = userDao.findUser(user.getUserCard());
        String nowTime = new Date().toString();
        String articleId = nowTime + user.toString();
        articleInfoDao.CreateNewArticle(articleInfo.getArticleTitle(),articleId, userRe.getUserId(), articleInfo.getArticleContext(),0,0);
        return true;
    }

    public List<ArticleInfo> getUserAllArticle(HttpServletRequest request){
        User userInfo = (User)request.getSession().getAttribute("userinfo");
        User user = userDao.findUser(userInfo.getUserCard());
        List<ArticleInfo> articleInfoList = articleInfoDao.findArticleInfoByUser(user.getUserId());
//        String dataByHtml = "{";
        return articleInfoList;
    }

    public List<ArticleComment> getAllCommentInArticle(HttpServletRequest request,String articleId){
        User userinfo = (User) request.getSession().getAttribute("userinfo");
        User user = userDao.findUser(userinfo.getUserCard());
        List<ArticleComment> articleComments = articleCommentDao.articleCommentList(articleId);
        return articleComments;
    }
}
