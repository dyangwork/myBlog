package com.blog.myBlog.service.impl;

import com.blog.myBlog.dao.BlogUserMapper;
import com.blog.myBlog.entity.BlogUser;
import com.blog.myBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private BlogUserMapper userMapper;

    @Override
    public int insert(BlogUser record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(BlogUser record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public BlogUser getUserByUserNameAndPassword(String userName,String password) {

        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        List<BlogUser> list = userMapper.getUserByUserNameAndPassword(map);
        if(list.size()<1){
            return null;
        }
        return list.get(0);
    }

    @Override
    public void updateUserByUserAccount(BlogUser user) {
        userMapper.updateUserByUserAccount(user);
    }

    @Override
    public void updateUserById(BlogUser user) {
        userMapper.updateUserById(user);
    }

    @Override
    public List<BlogUser> getUserById(List ids) {
        return userMapper.getUserById(ids);
    }
}
