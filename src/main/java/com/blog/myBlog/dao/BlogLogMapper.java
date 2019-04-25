package com.blog.myBlog.dao;

import com.blog.myBlog.entity.BlogLog;

public interface BlogLogMapper {
    int insert(BlogLog record);

    int insertSelective(BlogLog record);
}