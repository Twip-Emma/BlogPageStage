package com.example.blogpagestage.service;

import com.example.blogpagestage.dao.UserDao;
import com.example.blogpagestage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUserInfo(HttpServletRequest request){
        User re = (User)request.getSession().getAttribute("userinfo");
        if(re == null){
            return null;
        }else{
            User user = userDao.findUser(re.getUserCard());
            return user;
        }
    }
}
