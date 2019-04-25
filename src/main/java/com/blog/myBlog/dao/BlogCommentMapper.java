package com.blog.myBlog.dao;

import com.blog.myBlog.entity.BlogComment;

public interface BlogCommentMapper {
    int insert(BlogComment record);

    int insertSelective(BlogComment record);
}