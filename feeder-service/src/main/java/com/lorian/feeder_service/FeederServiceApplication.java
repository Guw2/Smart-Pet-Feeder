package com.lorian.feeder_service;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class FeederServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeederServiceApplication.class, args);
	}

}
