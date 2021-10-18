package com.example.blogpagestage.dao;

import com.example.blogpagestage.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user_info")
    @Results(id = "userInfo",
            value = {
                    @Result(id = true,column = "user_id",property = "userId"),
                    @Result(column = "user_card",property = "userCard"),
                    @Result(column = "user_pass",property = "userPass"),
                    @Result(column = "user_exp",property = "userExp"),
                    @Result(column = "user_name",property = "userName")
            })
    List<User> findAll();

    @ResultMap(value = "userInfo")
    @Insert("insert into user_info values(#{userId},#{userName},#{userCard},#{userPass},0)")
    void creatNewUser(String userId,String userCard,String userPass,String userName);

    @ResultMap(value = "userInfo")
    @Select("select * from user_info where user_card=#{userCard}")
    User findUser(String userCard);

    @ResultMap(value = "userInfo")
    @Update("update user_info set user_name=#{userName} where user_card=#{userCard}")
    void changeUserName(String userName,String userCard);

    @ResultMap(value = "userInfo")
    @Update("update user_info set user_exp=user_exp+1 where user_card=#{userCard}")
    void userGetExp(String userCard);
}
