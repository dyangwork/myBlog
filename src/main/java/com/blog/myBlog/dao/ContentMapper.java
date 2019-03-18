package com.blog.myBlog.dao;

import com.blog.myBlog.entity.Content;

public interface ContentMapper {
    int insert(Content record);

    int insertSelective(Content record);
}