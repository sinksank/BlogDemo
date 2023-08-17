package com.example.blogdemo.service;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.Comment;

import java.util.List;

public interface CommentService {
    void add(Comment comment);
    List<Comment> selectByArticleId(Integer articleId);

    void add1(Comment comment);
}
