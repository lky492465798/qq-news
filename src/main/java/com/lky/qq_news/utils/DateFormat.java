package com.lky.qq_news.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author lky
 * @Date 2021-11-12 12:41
 */
@Component
public class DateFormat {
    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss.ss";
    static SimpleDateFormat SimpleDateFormat = new SimpleDateFormat(FORMAT);

    public static String getDate(){
        return SimpleDateFormat.format(new Date());
    }

    public static String FormatTime(Date date){
        return SimpleDateFormat.format(date);
    }

}
