package com.example.blogdemo.service.impl;

import com.example.blogdemo.mapper.UserMapper;
import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.User;
import com.example.blogdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }


    @Override
    public User selectAll(Integer uid) {
        return userMapper.selectAll(uid);
    }

    @Override
    public User selectAll1(Integer uid) {
        return userMapper.selectAll1(uid);
    }
}
