package com.example.blogpagestage.service;

import com.example.blogpagestage.dao.ArticleInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleService {
    @Autowired
    ArticleInfoDao articleInfoDao;


}
