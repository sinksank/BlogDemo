package com.example.blogdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    private Integer articleId;
    private Integer uid;
    private String favoriteTime;
    private Integer id;
}
