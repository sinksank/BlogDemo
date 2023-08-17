package com.example.blogdemo.controller;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.Favorite;
import com.example.blogdemo.pojo.Follow;
import com.example.blogdemo.pojo.Result;
import com.example.blogdemo.service.FavoriteService;
import com.example.blogdemo.service.FollowService;
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
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    private FollowService followService;

    @RequestMapping("/del1")
    public Result del1(@RequestBody Article article,HttpSession session){
        Integer followingId= (Integer) session.getAttribute("uid");
        Integer followedId =article.getUid();
        try {
            followService.del1(followedId,followingId);
            return new Result(200,"取消关注成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"取消关注失败",e);
        }
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Article article, HttpSession session,Follow follow){
        Integer followingId = (Integer) session.getAttribute("uid");
        Integer followedId = article.getUid();
        follow.setFollowedId(followedId);
        follow.setFollowingId(followingId);
        try {
            followService.add(follow);
            return new Result(200,"关注成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"关注失败",e);
        }
    }

    @RequestMapping("/selectAll")
    public Result selectAll(HttpSession session){
        Integer followingId = (Integer) session.getAttribute("uid");
        try {
            List<Follow> follows = followService.selectAll(followingId);
            return new Result(200,"查询成功",follows);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(500,"查询失败",e);
        }
    }

    @RequestMapping("/selectAll1")
    public Result selectAll1(HttpSession session){
        Integer followingId= (Integer) session.getAttribute("uid");
        try {
            List<Follow> follows =followService.selectAll1(followingId);
            return new Result(200,"查询成功",follows);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"查询失败",e);
        }
    }

}
