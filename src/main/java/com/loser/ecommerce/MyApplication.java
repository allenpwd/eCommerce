package com.loser.ecommerce;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling //开启定时任务
@SpringBootApplication
@MapperScan(basePackages = {"com.loser.ecommerce.mapper"})
public class MyApplication {

    private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) {
        logger.info("正在启动...");
        SpringApplication.run(MyApplication.class, args);
        logger.info("启动完成...");
    }

}
