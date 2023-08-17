package com.example.blogdemo.mapper;

import com.example.blogdemo.pojo.Favorite;
import com.example.blogdemo.pojo.Follow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {

     void add(Follow follow);

    void del1(Integer followedId, Integer followingId);

    List<Follow> selectAll(Integer followingId);

    List<Follow> selectAll1(Integer followingId);

}
