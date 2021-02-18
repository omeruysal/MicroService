package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HystrixDashBoardApplication.class, args);
	}


}
