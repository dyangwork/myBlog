package com.blog.myBlog.dao;

import com.blog.myBlog.entity.BlogMeta;

public interface BlogMetaMapper {
    int insert(BlogMeta record);

    int insertSelective(BlogMeta record);
}