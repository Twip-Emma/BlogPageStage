package com.example.blogpagestage.tool;

import com.example.blogpagestage.dao.UserDao;
import com.example.blogpagestage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserTool {
    @Autowired
    UserDao userDao;

    public Boolean checkNewUser(User user){
        User re = userDao.findUserByUserCard(user.getUserCard());
        if(re != null){
            //数据库内有这个用户了..
            return false;
        }else{
            return true;
        }
    }

    public Boolean checkUserPass(User user){
        User re = userDao.findUserByUserCard(user.getUserCard());
        if(re.getUserPass().equals(user.getUserPass())){
            //密码正确了...
            return true;
        }else{
            return false;
        }
    }

    public User findUserByUserId(String userId){
        User user = userDao.findUserByUserId(userId);
        return user;
    }

    public String getUserUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "+userid+");
        return uuidStr;
    }

    public String getArticleUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "+article+");
        return uuidStr;
    }

    public String getCommentUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "+comment+");
        return uuidStr;
    }
}
