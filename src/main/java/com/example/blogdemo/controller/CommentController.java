package com.example.blogdemo.controller;


import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.Comment;
import com.example.blogdemo.pojo.Result;
import com.example.blogdemo.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/add")
    public Result add(@RequestBody Comment comment,HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        comment.setUid(uid);
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setCommentTime(df.format(date));
        try {
            commentService.add(comment);
            return new Result(200,"评论发布成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"评论未发布成功",e);
        }
    }

    @RequestMapping("/selectByArticleId")
    public Result selectByArticleId(String articleId){
        try {
            List<Comment> comments = commentService.selectByArticleId(Integer.valueOf(articleId));
            return new Result(200,"查询成功",comments);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(500,"查询失败",e);
        }
    }

    @RequestMapping("/add1")
    public Result add1(@RequestBody Comment comment){
        try {
            commentService.add1(comment);
            return new Result(200,"点赞成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"点赞失败",e);
        }
    }


}
