package com.blog.myblog.dao;

import com.blog.myblog.entity.BlogComment;

public interface BlogCommentMapper {
    int insert(BlogComment record);

    int insertSelective(BlogComment record);
}