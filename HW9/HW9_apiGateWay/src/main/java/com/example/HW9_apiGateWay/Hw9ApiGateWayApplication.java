package com.example.HW9_apiGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Hw9ApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw9ApiGateWayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("Microservice", r -> r.path("/service/**")
						.uri("http://localhost:8081/")).build();
	}
}
