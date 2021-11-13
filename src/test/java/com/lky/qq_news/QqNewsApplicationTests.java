package com.lky.qq_news;

import com.lky.qq_news.utils.RealNewsUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QqNewsApplicationTests {

//    @Autowired
//    NewsTopUtil newsTopUtil;
//    @Autowired
//    NewsTopDao dao;
//    @Autowired
//    TodayTopicDao dao;
    @Autowired
    RealNewsUtil realNewsUtil;


    @Test
    void contextLoads() {
        realNewsUtil.run();
    }

}
