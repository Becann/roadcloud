package com.cgutech.roadcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Becan on 2017/6/6.
 */
@SpringBootApplication
@EnableTransactionManagement //启动注解事务管理
public class Application {
    @Autowired
    MongoTemplate mongoTemplate;
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
