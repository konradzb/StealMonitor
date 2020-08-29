package com.kk.StealMonitor;

import com.kk.StealMonitor.service.ScheduleRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
@SpringBootTest
public class ScheduleRunnerTest2 {

    @Autowired
    private ScheduleRunner scheduleRunner;

    @Test
    public void load_XKom_HotShotTest() {
        assertEquals(scheduleRunner.load_XKom_HotShot(), 1);
    }
}
