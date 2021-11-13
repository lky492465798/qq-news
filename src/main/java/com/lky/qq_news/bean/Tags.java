package com.lky.qq_news.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author lky
 * @Date 2021-11-12 18:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tags {

    private String tag_id;
    private String tag_word;
    private String tag_score;

}
