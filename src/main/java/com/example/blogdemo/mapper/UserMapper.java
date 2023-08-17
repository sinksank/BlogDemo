package com.example.blogdemo.mapper;

import com.example.blogdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectALL();

    void add(User user);

    User selectByUsername(String username);

    User selectAll(Integer uid);

    User selectAll1(Integer uid);
}
