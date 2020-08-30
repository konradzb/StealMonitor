package com.kk.StealMonitor;

import com.kk.StealMonitor.service.ScheduleRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StealMonitorApplication {

	@Autowired
	private static ScheduleRunner scheduleRunner;

	public static void main(String[] args) {
		SpringApplication.run(StealMonitorApplication.class, args);
	}

}
