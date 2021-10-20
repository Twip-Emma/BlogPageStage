package com.example.blogpagestage.entity;

import lombok.Data;

@Data
public class UserDetail {
    private String userId;
    private String userHeadImage;
    private Integer userArticleTotal;
    private Integer userCommentTotal;
    private Integer userStarTotal;
}
