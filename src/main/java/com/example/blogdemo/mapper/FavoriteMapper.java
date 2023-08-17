package com.example.blogdemo.mapper;


import com.example.blogdemo.pojo.Favorite;
import com.example.blogdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface FavoriteMapper {
    List<Favorite> selectByArticleId(Integer articleId);

    void del(Integer uid,Integer articleId);

    void add(Favorite favorite);

    List<Favorite> selectAll(Integer uid);
}
