package com.example.schedule;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScheduleBean
{
	@Scheduled(fixedDelay = 1000)
	public void scheduleTask()
	{
		String currentFormattedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		log.info("Hello from ScheduleBean at {}", currentFormattedTime);
	}
}
