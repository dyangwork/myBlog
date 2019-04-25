package com.blog.myBlog.dao;

import com.blog.myBlog.entity.BlogFile;

public interface BlogFileMapper {
    int insert(BlogFile record);

    int insertSelective(BlogFile record);
}