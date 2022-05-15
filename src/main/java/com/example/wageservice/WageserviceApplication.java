package com.example.wageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WageserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WageserviceApplication.class, args);
	}

}
