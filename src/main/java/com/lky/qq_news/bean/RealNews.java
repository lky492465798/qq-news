package com.lky.qq_news.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author lky
 * @Date 2021-11-12 18:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="real_news")
public class RealNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cms_id;//新闻编号
    private String title;//名字
    @Transient
    private String subtitle;
    private String url;//地址
    private String thumb_nail;//地址1
    private String thumb_nail_2x;//地址2
    @Transient
    private List<String> top_big_img;
    @Transient
    private String category_id;
    @Transient
    private String category_name;
    @Transient
    private String category_cn;
    @Transient
    private String sub_category_id;
    @Transient
    private String sub_category_name;
    @Transient
    private String sub_category_cn;
    @Transient
    private int status;
    @Transient
    private List<Tags> tags;
    @Transient
    private String media_id;
    private String media_name;//媒体名字
    @Transient
    private String point;
    @Transient
    private int article_type;
    @Transient
    private String pool_name;
    @Transient
    private int security_field;
    @Transient
    private String article_id;
    @Transient
    private String source;
    @Transient
    private String comment_id;
    @Transient
    private String comment_num;
    @Transient
    private Date create_time;
    @Transient
    private Date update_time;
    private Date publish_time;//发布时间
    @Transient
    private String img_exp_type;
    private String img;

}
