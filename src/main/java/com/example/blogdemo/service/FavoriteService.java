package com.example.blogdemo.service;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.Favorite;
import com.example.blogdemo.pojo.User;

import java.util.List;

public interface FavoriteService {

    List<Favorite> selectByArticleId(Integer articleId);

    void del(Integer uid,Integer articleId);

    void add(Favorite favorite);

    List<Favorite> selectAll(Integer uid);
}
