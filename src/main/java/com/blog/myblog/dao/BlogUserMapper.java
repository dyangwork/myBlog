package com.blog.myblog.dao;

import com.blog.myblog.entity.BlogUser;

import java.util.List;
import java.util.Map;

//@Resource(name = "userMapper")
//@Component
public interface BlogUserMapper {
    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    List<BlogUser> getUserByUserNameAndPassword(Map<String,Object> map);

    void updateUserByUserAccount(BlogUser user);

    void updateUserById(BlogUser user);

    List<BlogUser> getUserById(List<String> ids);
}