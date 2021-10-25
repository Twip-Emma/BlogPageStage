package com.example.blogpagestage.entity;

import lombok.Data;

@Data
public class ArticleInfo {
    private String articleId;
    private String userId;
    private String articleContext;
    private Integer articleGoodEl;
    private Integer articleBadEl;
}
