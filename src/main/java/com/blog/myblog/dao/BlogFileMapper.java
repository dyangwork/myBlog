package com.blog.myblog.dao;

import com.blog.myblog.entity.BlogFile;

public interface BlogFileMapper {
    int insert(BlogFile record);

    int insertSelective(BlogFile record);
}