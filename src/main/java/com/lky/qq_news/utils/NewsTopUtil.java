package com.lky.qq_news.utils;


import com.alibaba.fastjson.JSON;
import com.lky.qq_news.bean.NewsTop;
import com.lky.qq_news.service.NewsTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author lky
 * @Date 2021-11-12 12:42
 */
@Component
public class NewsTopUtil implements PageProcessor {

    static NewsTopService newsTopService;

    @Autowired
    public void setNewsTopService(NewsTopService newsTopService){
        NewsTopUtil.newsTopService = newsTopService;
    }

    String news_top_url = "https://i.news.qq.com/trpc.qqnews_web.pc_base_srv.base_http_proxy/NinjaPageContentSync?pull_urls=news_top_2018";

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        List<String> newsList = new JsonPathSelector("$.data[*]").selectList(page.getRawText());
        List<NewsTop> lists = new ArrayList<>();
        for (int i = 0; i < newsList.size(); i++) {
            NewsTop news = JSON.parseObject(newsList.get(i), NewsTop.class);
            news.setCreateTime(DateFormat.getDate());
            lists.add(news);
        }
        for (int i = 0; i < lists.size(); i++) {
            newsTopService.save(lists.get(i));
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Scheduled(cron = "0 0 0,13,18,21 * * ?")
    public void run() {
        Spider.create(new NewsTopUtil()).addUrl(news_top_url).run();
    }

    public static void main(String[] args) {
        new NewsTopUtil().run();
    }
}
