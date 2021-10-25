package com.example.blogpagestage.entity;

import lombok.Data;

@Data
public class ArticleComment {
    private String articleId;
    private String commentId;
    private String userId;
    private String commentContext;
    private String commentGoodEl;
    private String commentBadEl;
}
