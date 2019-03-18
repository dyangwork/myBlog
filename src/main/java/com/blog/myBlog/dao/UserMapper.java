package com.blog.myBlog.dao;

import com.blog.myBlog.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}