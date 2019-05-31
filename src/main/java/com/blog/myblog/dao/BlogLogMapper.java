package com.blog.myblog.dao;

import com.blog.myblog.entity.BlogLog;

public interface BlogLogMapper {
    int insert(BlogLog record);

    int insertSelective(BlogLog record);
}