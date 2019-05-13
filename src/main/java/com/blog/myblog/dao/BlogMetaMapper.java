package com.blog.myblog.dao;

import com.blog.myblog.entity.BlogMeta;

public interface BlogMetaMapper {
    int insert(BlogMeta record);

    int insertSelective(BlogMeta record);
}