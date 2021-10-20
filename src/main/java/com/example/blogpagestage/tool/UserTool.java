package com.example.blogpagestage.tool;

import com.example.blogpagestage.dao.UserDao;
import com.example.blogpagestage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTool {
    @Autowired
    UserDao userDao;

    public Boolean checkNewUser(User user){
        User re = userDao.findUser(user.getUserCard());
        if(re != null){
            //数据库内有这个用户了..
            return false;
        }else{
            return true;
        }
    }

    public Boolean checkUserPass(User user){
        User re = userDao.findUser(user.getUserCard());
        if(re.getUserPass().equals(user.getUserPass())){
            //密码正确了...
            return true;
        }else{
            return false;
        }
    }
}
