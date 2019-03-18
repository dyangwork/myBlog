package com.blog.myBlog.dao;

import com.blog.myBlog.entity.Attach;

public interface AttachMapper {
    int insert(Attach record);

    int insertSelective(Attach record);
}