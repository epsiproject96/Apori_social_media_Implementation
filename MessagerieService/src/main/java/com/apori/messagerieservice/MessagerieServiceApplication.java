package com.apori.messagerieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MessagerieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagerieServiceApplication.class, args);
	}
}
