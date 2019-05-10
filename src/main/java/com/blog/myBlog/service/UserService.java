package com.blog.myBlog.service;

import com.blog.myBlog.entity.BlogUser;

import java.util.List;

public interface UserService {

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    BlogUser getUserByUserNameAndPassword(String userName,String password);

    void updateUserByUserAccount(BlogUser user);

    void updateUserById(BlogUser user);

    List<BlogUser> getUserById(List ids);
}
