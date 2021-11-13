package com.lky.qq_news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class QqNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(QqNewsApplication.class, args);
    }

}
