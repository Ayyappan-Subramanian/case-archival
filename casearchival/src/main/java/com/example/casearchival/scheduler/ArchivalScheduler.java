package com.example.casearchival.scheduler;

import com.example.casearchival.service.CasearchivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ArchivalScheduler {
    @Autowired
    private CasearchivalService archivalservice;

    @Scheduled(cron = "0 */5 * * * *")
    public void runArchivalJob() {
        archivalservice.runarchival();
    }
}
