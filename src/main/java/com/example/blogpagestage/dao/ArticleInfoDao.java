package com.example.blogpagestage.dao;

import com.example.blogpagestage.entity.ArticleInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleInfoDao {

    @Select("select * from article_info")
    @Results(id="articleInfo",
            value = {
                    @Result(id = true,column = "article_id", property = "articleId"),
                    @Result(id = true,column = "article_context", property = "articleContext"),
                    @Result(id = true,column = "article_good_el", property = "articleGoodEl"),
                    @Result(id = true,column = "article_bad_el", property = "articleBadEl"),
                    @Result(id = true,column = "user_id", property = "userId")
            })
    List<ArticleInfo> findAll();

    @ResultMap(value = "articleInfo")
    @Insert("insert into article_info (article_id,article_context,article_good_el,article_bad_el,user_id)" +
            "values(#{articleId},#{articleContext},#{articleGoodEl},#{articleBadEl},#{userId})")
    void CreateNewArticle(String articleId,String userId,String articleContext,Integer articleGoodEl,Integer articleBadEl);

    @ResultMap(value = "articleInfo")
    @Select("select * from article where article_id=#{articleId}")
    ArticleInfo findArticleInfo(String articleId);

    @ResultMap(value = "articleInfo")
    @Select("select * from article where user_id=#{userId}")
    List<ArticleInfo> findArticleInfoByUser(String userId);
}
