package com.example.blogdemo.service.impl;

import com.example.blogdemo.mapper.FavoriteMapper;
import com.example.blogdemo.pojo.Favorite;
import com.example.blogdemo.pojo.User;
import com.example.blogdemo.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public List<Favorite> selectByArticleId(Integer articleId) {
        return favoriteMapper.selectByArticleId(articleId);
    }

    @Override
    public void del(Integer uid,Integer articleId) {
         favoriteMapper.del(uid,articleId);
    }

    @Override
    public void add(Favorite favorite) {
        favoriteMapper.add(favorite);
    }

    @Override
    public List<Favorite> selectAll(Integer uid) {
        return favoriteMapper.selectAll(uid);
    }

}
