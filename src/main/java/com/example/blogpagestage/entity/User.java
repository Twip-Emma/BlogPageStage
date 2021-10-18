package com.example.blogpagestage.entity;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String userName;
    private String userCard;
    private String userPass;
    private Integer userExp;
}
