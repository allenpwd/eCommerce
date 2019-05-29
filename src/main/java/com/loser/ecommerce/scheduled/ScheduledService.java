package com.loser.ecommerce.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时任务，
 */
@Component
public class ScheduledService {

    private static final Integer defualtDay = -1;//默认统计第上X天，只统计当天

    @Scheduled(cron = "0 15 0 * * *")
    public void reportLoginLosService() {
        System.out.println("test");
    }

    private LocalDateTime getYesterday(String beginOrEndStr) {
        LocalDateTime yesterday = LocalDateTime.now().plusDays(defualtDay);
        switch (beginOrEndStr) {
            case "begin":
                return LocalDateTime.of(yesterday.getYear(), yesterday.getMonth(),
                        yesterday.getDayOfMonth(), 0, 0, 0);
            case "end":
                return LocalDateTime.of(yesterday.getYear(), yesterday.getMonth(),
                        yesterday.getDayOfMonth(), 23, 59, 59);
            default:
                return LocalDateTime.of(yesterday.getYear(), yesterday.getMonth(),
                        yesterday.getDayOfMonth(), 0, 0, 0);
        }
    }
}
