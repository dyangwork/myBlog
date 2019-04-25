package com.blog.myBlog.dao;

import com.blog.myBlog.entity.PlaceOnFile;

public interface PlaceOnFileMapper {
    int insert(PlaceOnFile record);

    int insertSelective(PlaceOnFile record);
}