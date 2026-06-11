package com.example.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulerExample
{
	private static ScheduleBean bean = new ScheduleBean();

	public static void main(String[] args)
	{
		SpringApplication.run(SchedulerExample.class , args);
		bean.scheduleTask();
	}
}
