package com.lky.qq_news.dao;

import com.lky.qq_news.bean.RealNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealNewsDao extends JpaRepository<RealNews,Long> {
}
