package com.lky.qq_news.serviceImpl;

import com.lky.qq_news.bean.NewsTop;
import com.lky.qq_news.dao.NewsTopDao;
import com.lky.qq_news.service.NewsTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author lky
 * @Date 2021-11-12 20:06
 */
@Service
public class NewsTopServiceImpl implements NewsTopService {

    @Autowired
    NewsTopDao newsTopDao;

    @Override
    @Transactional
    public void save(NewsTop newsTop) {
        NewsTop top = new NewsTop();
        top.setArticle_id(newsTop.getArticle_id());
        top.setGroup(newsTop.getGroup());
        top.setTitle(newsTop.getTitle());
        if (!findNewsTop(top)){
            newsTopDao.saveAndFlush(newsTop);
        }
    }

    public boolean findNewsTop(NewsTop newsTop){
        Example<NewsTop> of = Example.of(newsTop);
        return newsTopDao.exists(of);
    }

}
