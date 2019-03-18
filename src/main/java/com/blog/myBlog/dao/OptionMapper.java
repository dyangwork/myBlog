package com.blog.myBlog.dao;

import com.blog.myBlog.entity.Option;

public interface OptionMapper {
    int insert(Option record);

    int insertSelective(Option record);
}