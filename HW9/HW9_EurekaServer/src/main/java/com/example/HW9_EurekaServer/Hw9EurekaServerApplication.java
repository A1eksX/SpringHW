package com.example.HW9_EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Hw9EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw9EurekaServerApplication.class, args);
	}

}
