package com.app.motorcycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MotorcycleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotorcycleApplication.class, args);
	}

}
