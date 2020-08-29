package com.kk.StealMonitor.integration;

import com.kk.StealMonitor.service.ScheduleRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
@SpringBootTest
public class ScheduleRunnerTestIntgr {

    @Autowired
    private ScheduleRunner scheduleRunner;

    @Test
    public void load_XKom_HotShotTest() {
        assertEquals(scheduleRunner.load_XKom_HotShot(), 1);
        //check terminal with "SELECT * FROM products;" if rows was actually added to DB
    }
}
