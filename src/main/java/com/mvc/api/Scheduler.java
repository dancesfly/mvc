package com.mvc.api;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduler {
	
	@Scheduled(fixedRate = 5000)
	public void test() {
		System.out.println("hello Scheduled");
	}
}
