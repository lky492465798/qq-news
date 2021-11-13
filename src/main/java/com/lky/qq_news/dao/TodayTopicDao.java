package com.lky.qq_news.dao;

import com.lky.qq_news.bean.TodayTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodayTopicDao extends JpaRepository<TodayTopic,Long> {
}
