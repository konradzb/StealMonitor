package com.kk.StealMonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleRunner {

    private final PageLoader pageLoader;

    @Autowired
    public ScheduleRunner(PageLoader pageLoader) {
        this.pageLoader = pageLoader;
    }


}