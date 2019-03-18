package com.blog.myBlog.dao;

import com.blog.myBlog.entity.Meta;

public interface MetaMapper {
    int insert(Meta record);

    int insertSelective(Meta record);
}