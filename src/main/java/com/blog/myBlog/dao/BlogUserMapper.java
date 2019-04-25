package com.blog.myBlog.dao;

import com.blog.myBlog.entity.BlogUser;

public interface BlogUserMapper {
    int insert(BlogUser record);

    int insertSelective(BlogUser record);
}