package com.lky.qq_news.utils;

import com.alibaba.fastjson.JSON;
import com.lky.qq_news.bean.RealNews;
import com.lky.qq_news.service.RealNewsService;
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
 * @Date 2021-11-12 16:16
 */
@Component
public class RealNewsUtil implements PageProcessor {

    static RealNewsService realNewsService;

    @Autowired
    public void setNewsTopService(RealNewsService realNewsService){
        RealNewsUtil.realNewsService = realNewsService;
    }

    static String real_news_url = "https://i.news.qq.com/trpc.qqnews_web.kv_srv.kv_srv_http_proxy/list?sub_srv_id=24hours&srv_id=pc&offset=0&limit=20&strategy=1&ext=%7B%22pool%22:[%22top%22],%22is_filter%22:7,%22check_type%22:true%7D";
    @Override
    public void process(Page page) {
        List<String> newsList = new JsonPathSelector("$.data.list[*]").selectList(page.getRawText());
        List<RealNews> lists = new ArrayList<>();
        for (int i = 0; i < newsList.size(); i++) {
            RealNews news = JSON.parseObject(newsList.get(i), RealNews.class);
            lists.add(news);
        }
        for (int i = 0; i < newsList.size(); i++) {
            realNewsService.Save(lists.get(i));
        }
    }

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public Site getSite() {
        return this.site;
    }

    @Scheduled(cron = "0 */30 * * * ?")
    public void run() {
        Spider.create(new RealNewsUtil())
                .addUrl(real_news_url)
                .run();
    }

}
