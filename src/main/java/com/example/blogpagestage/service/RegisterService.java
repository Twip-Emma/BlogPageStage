package com.example.blogpagestage.service;

import com.example.blogpagestage.dao.UserDao;
import com.example.blogpagestage.entity.User;
import com.example.blogpagestage.tool.UserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RegisterService {
    @Autowired
    UserDao userDao;

    @Autowired
    UserTool userTool;

    public Boolean CreatNewUser(User user) {
        Boolean re = userTool.checkNewUser(user);
        if (re) {
            String nowTime = new Date().toString();
            user.setUserId(nowTime + user.getUserCard());
            userDao.creatNewUser(user.getUserId(), user.getUserCard(), user.getUserPass(), user.getUserName());
            return true;
        } else {
            return false;
        }


    }
}
