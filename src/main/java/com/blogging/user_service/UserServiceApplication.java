package com.blogging.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class UserServiceApplication {

	public static void main(String[] args) {
		System.out.println("starting user-service");
		SpringApplication.run(UserServiceApplication.class, args);
		System.out.println("user-service is up");
	}

}
