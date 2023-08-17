package com.example.blogdemo.service;
import java.util.List;

import com.example.blogdemo.pojo.Favorite;
import com.example.blogdemo.pojo.Follow;
public interface FollowService {
    void del1(Integer followedId,Integer followingId);

    void add(Follow follow);

    List<Follow> selectAll(Integer followingId);

    List<Follow> selectAll1(Integer followingId);
}
