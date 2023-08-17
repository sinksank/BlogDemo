package com.example.blogdemo.service;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.User;

import java.util.List;

public interface UserService {


    User selectByUsername(String username);

    void add(User user);
    User selectAll(Integer uid);

    User selectAll1(Integer uid);
}
