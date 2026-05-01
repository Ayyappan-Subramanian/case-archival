package com.example.casearchival;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CasearchivalApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CasearchivalApplication.class, args);

	}

}
