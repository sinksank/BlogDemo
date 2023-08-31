package com.example.blogdemo.controller;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.Follow;
import com.example.blogdemo.pojo.Result;
import com.example.blogdemo.pojo.User;
import com.example.blogdemo.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public Result add(@RequestBody User user){
        Date date= new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setRegistrationTime(df.format(date));
        String password=user.getPassword();
        String salt="114514";
        password=password+salt;
        password= DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        user.setPassword(password);
        try {
            userService.add(user);
            return new Result(200,"用户注册成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(500,"注册失败",e);
        }

    }
    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpSession session){
        User result=userService.selectByUsername(user.getUsername());
        if(result==null){
            return new Result(200,"登陆成功");
        }
        String password= user.getPassword();
        String salt="114514";
        password=password+salt;
        password=DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if(result.getPassword().equals(password)){
            session.setAttribute("uid",result.getUid());
            return new Result(200,"登陆成功");
        }else {
            return new Result(300,"登陆失败");
        }
    }


    @RequestMapping("/selectAll")
    public Result selectAll(HttpSession session){
        Integer uid= (Integer) session.getAttribute("uid");
        try {
            User user =userService.selectAll(uid);
            return new Result(200,"查询成功",user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"查询失败",e);
        }
    }

    @RequestMapping("/selectAll1")
    public Result selectAll1(){
        try {
            List<User> users =userService.selectAll1();
            return new Result(200,"查询成功",users);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"查询失败",e);
        }
    }

}
