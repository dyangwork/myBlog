package com.blog.myblog.dao;

import com.blog.myblog.entity.PlaceOnFile;

public interface PlaceOnFileMapper {
    int insert(PlaceOnFile record);

    int insertSelective(PlaceOnFile record);
}