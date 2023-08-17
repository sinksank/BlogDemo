package com.example.blogdemo.service.impl;

import com.example.blogdemo.mapper.CommentMapper;
import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.Comment;
import com.example.blogdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void add(Comment comment) {
        commentMapper.add(comment);
    }

    @Override
    public List<Comment> selectByArticleId(Integer articleId) {
        return commentMapper.selectByArticleId(articleId);
    }

    @Override
    public void add1(Comment comment) {commentMapper.add1(comment);}
}
