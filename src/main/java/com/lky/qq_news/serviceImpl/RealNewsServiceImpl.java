package com.lky.qq_news.serviceImpl;

import com.lky.qq_news.bean.RealNews;
import com.lky.qq_news.dao.RealNewsDao;
import com.lky.qq_news.service.RealNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author lky
 * @Date 2021-11-13 15:56
 */
@Service
public class RealNewsServiceImpl implements RealNewsService {

    @Autowired
    RealNewsDao realNewsDao;

    @Override
    @Transactional
    public void Save(RealNews realNews) {
        if (!findRealNews(realNews)){
            realNewsDao.save(realNews);
        }
    }

    public boolean findRealNews(RealNews realNews){
        Example<RealNews> of = Example.of(realNews);
        return realNewsDao.exists(of);
    }


}
