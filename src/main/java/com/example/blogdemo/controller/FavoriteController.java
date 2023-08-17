package com.example.blogdemo.controller;

import com.example.blogdemo.pojo.*;
import com.example.blogdemo.service.CommentService;
import com.example.blogdemo.service.FavoriteService;
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
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;


    @RequestMapping("/selectByArticleId")
    public Result selectByArticleId(String articleId){
        try {
            List<Favorite> favorites = favoriteService.selectByArticleId(Integer.valueOf(articleId));
            return new Result(200,"查询成功",favorites);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(500,"查询失败",e);
        }
    }

    @RequestMapping("/del")
    public Result del(@RequestBody Article article,HttpSession session){
        Integer uid= (Integer) session.getAttribute("uid");
        try {
            favoriteService.del(uid,article.getArticleId());
            return new Result(200,"取消关注成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"取消关注失败",e);
        }
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Article article,HttpSession session,Favorite favorite){
        Integer uid = (Integer) session.getAttribute("uid");
        Date date= new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        favorite.setFavoriteTime(df.format(date));
        favorite.setUid(uid);
        favorite.setArticleId(article.getArticleId());
        try {
            favoriteService.add(favorite);
            return new Result(200,"关注成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"关注失败",e);
        }
    }

    @RequestMapping("/selectAll")
    public Result selectAll(HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        try {
            List<Favorite> favorites = favoriteService.selectAll(uid);
            return new Result(200,"查询成功",favorites);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(500,"查询失败",e);
        }
    }
}
