package com.example.blogpagestage.dao;

import com.example.blogpagestage.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDetailDao {
    @Select("select * from user_info_detail")
    @Results(id = "userInfo",
            value = {
                    @Result(id = true, column = "user_id", property = "userId"),
                    @Result(column = "user_head_image", property = "userHeadImage"),
                    @Result(column = "user_article_total", property = "userArticleTotal"),
                    @Result(column = "user_comment_total", property = "userCommentTotal"),
                    @Result(column = "user_star_total", property = "userStarTotal")
            })
    List<User> findAll();

    @ResultMap(value = "userInfo")
    @Insert("insert into user_info_detail (user_id,user_head_image,user_article_total,user_comment_total,user_star_total)values(#{userId},'-',0,0,0)")
    void creatNewUser(String userId);

    @ResultMap(value = "userInfo")
    @Select("select * from user_info_detail where user_card=#{userCard}")
    User findUser(String userCard);

    @ResultMap(value = "userInfo")
    @Update("update user_info_detail set user_name=#{userName} where user_card=#{userCard}")
    void changeUserName(String userName, String userCard);

    @ResultMap(value = "userInfo")
    @Update("update user_info_detail set user_exp=user_exp+1 where user_card=#{userCard}")
    void userGetExp(String userCard);
}
