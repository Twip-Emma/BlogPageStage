package com.example.blogpagestage.dao;

import com.example.blogpagestage.entity.ArticleComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleCommentDao {

    @Select("select * from article_comment")
    @Results(id = "articleComment",
            value = {
                    @Result(id = true,column = "article_id", property = "articleId"),
                    @Result(id = true,column = "comment_id", property = "commentId"),
                    @Result(id = true,column = "user_id", property = "userId"),
                    @Result(id = true,column = "comment_context", property = "commentContext"),
                    @Result(id = true,column = "comment_good_el", property = "commentGoodEl"),
                    @Result(id = true,column = "comment_bad_el", property = "commentBadEl")
            })
    List<ArticleComment> findAll();


    @ResultMap(value = "articleComment")
    @Insert("insert into article_comment (article_id,comment_id,user_id,comment_context,comment_good_el,comment_bad_el)" +
            "values(#{articleId},#{commentId},#{userId},#{commentContext},#{commentGoodEl},#{commentBadEl})")
    void creatNewComment(String articleId,String commentId,String userId,String commentContext,Integer commentGoodEl,Integer commentBadEl);


    @ResultMap(value = "articleComment")
    @Select("select * from article_comment where comment_id=#{commentId}")
    ArticleComment findComment(String commentId);
}
