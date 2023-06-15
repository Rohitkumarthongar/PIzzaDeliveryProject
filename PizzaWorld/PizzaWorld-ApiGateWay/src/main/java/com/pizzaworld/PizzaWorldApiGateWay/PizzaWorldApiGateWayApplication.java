package com.pizzaworld.PizzaWorldApiGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
@EnableEurekaClient
@SpringBootApplication
public class
PizzaWorldApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaWorldApiGateWayApplication.class, args);
	}
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes().
				route(r -> r.path("/api/pizza/Auth/**").uri("http://localhost:8001/"))
				.route(r -> r.path("/api/pizza/service/**").uri("http://localhost:8002/"))
				.build();
	}
}
