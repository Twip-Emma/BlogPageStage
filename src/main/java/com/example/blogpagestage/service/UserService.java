package com.example.blogpagestage.service;

import com.example.blogpagestage.dao.UserDao;
import com.example.blogpagestage.dao.UserDetailDao;
import com.example.blogpagestage.entity.User;
import com.example.blogpagestage.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    UserDetailDao userDetailDao;

    public Map<String, Object> getUserInfo(HttpServletRequest request){
        Map<String, Object> userMaps = new HashMap<>();
        User re = (User)request.getSession().getAttribute("userinfo");
        if(re == null){
            return null;
        }else{
            User user = userDao.findUser(re.getUserCard());
            userMaps.put("userinfo",user);
            UserDetail userDetailDaoUser = userDetailDao.findUser(user.getUserId());
            userMaps.put("userdetail",userDetailDaoUser);
            return userMaps;
        }
    }
}
