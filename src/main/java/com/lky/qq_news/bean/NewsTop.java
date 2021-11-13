package com.lky.qq_news.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Description
 * @Author lky
 * @Date 2021-11-12 17:49
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news_top")
public class NewsTop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="url")
    private String url;
    @Column(name="img_url")
    private String img_url;
    @Column(name="article_id")
    private String article_id;
    @Column(name="comment_id")
    private String comment_id;
    @Column(name="title")
    private String title;
    @Column(name="group_id")
    private int group;
    @Column(name="create_time")
    private String createTime;

}

