package com.blog.myBlog.dao;

import com.blog.myBlog.entity.Comment;

public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);
}