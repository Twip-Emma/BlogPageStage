## 数据库表

#### 用户表user_info
>- user_id varchar 用户id，后台自动生成
>- user_name varchar 用户昵称，由用户自定义，默认为用户通行证
>- user_card varchar 用户通行证，由用户注册时填入
>- user_pass varchar 用户密码，由用户注册时填入
>- user_exp int 用户经验值

#### 用户信息表user_info_detail
>- user_id varchar 用户id，后台自动生成
>- user_head_image varchar 用户头像路径，由用户传入，默认-
>- user_article_total int 发布过的文章数量
>- user_comment_total int 发表过的评论数量
>- user_star_total int 用户获得的点赞总数

#### 文章表article_info
>- article_id varchar 文章id，后台自动生成
>- user_id varchar 用户id
>- article_context varchar 文章正文
>- article_good_el int 文章赞
>- article_bad_el int 文章踩


#### 文章评论表article_comment
>- article_id varchar 文章id，后台自动生成
>- comment_id varchar 评论id，后台自动生成
>- user_id varchar 用户id
>- comment_context varchar 评论正文
>- comment_good_el int 评论赞
>- comment_bad_el int 评论踩


## 目前已实现的功能

#### 登录系统
>- 登录，判断是否成功且是否是未被注册的账号做判断
>- 创建新用户，并且判断是否重复
>- 登录状态：通过判断登陆状态来获取基本信息