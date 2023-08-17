package com.example.blogdemo.service.impl;

import com.example.blogdemo.mapper.FavoriteMapper;
import com.example.blogdemo.mapper.FollowMapper;
import com.example.blogdemo.pojo.Favorite;
import com.example.blogdemo.pojo.Follow;
import com.example.blogdemo.service.FavoriteService;
import com.example.blogdemo.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followMapper;


    @Override
    public void del1(Integer followedId,Integer followingId) {
        followMapper.del1(followedId,followingId);
    }

    @Override
    public void add(Follow follow) {
        followMapper.add(follow);
    }

    @Override
    public List<Follow> selectAll(Integer followingId) {
        return followMapper.selectAll(followingId);
    }

    @Override
    public List<Follow> selectAll1(Integer followingId) {
        return followMapper.selectAll1(followingId);
    }

}
