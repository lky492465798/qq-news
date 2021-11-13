package com.lky.qq_news.serviceImpl;

import com.lky.qq_news.bean.TodayTopic;
import com.lky.qq_news.dao.TodayTopicDao;
import com.lky.qq_news.service.TodayTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author lky
 * @Date 2021-11-12 22:16
 */
@Service
public class TodayTopicServiceImpl implements TodayTopicService {

    @Autowired
    TodayTopicDao todayTopicDao;

    @Override
    @Transactional
    public void save(TodayTopic todayTopic) {
        TodayTopic topic = new TodayTopic();
        topic.setArticle_id(todayTopic.getArticle_id());
        topic.setGroup(todayTopic.getGroup());
        if (!findTodayTopic(topic)){
            todayTopicDao.saveAndFlush(todayTopic);
        }
    }

    public boolean findTodayTopic(TodayTopic todayTopic){
        Example<TodayTopic> of = Example.of(todayTopic);
        return todayTopicDao.exists(of);
    }
}
