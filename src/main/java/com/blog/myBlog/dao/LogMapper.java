package com.blog.myBlog.dao;

import com.blog.myBlog.entity.Log;

public interface LogMapper {
    int insert(Log record);

    int insertSelective(Log record);
}