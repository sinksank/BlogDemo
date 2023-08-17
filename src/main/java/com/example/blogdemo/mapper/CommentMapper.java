package com.example.blogdemo.mapper;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void add(Comment comment);

    List<Comment> selectByArticleId(Integer articleId);

    void add1(Comment comment);
}
