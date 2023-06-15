package com.pizzaworld.PizzaWorldEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PizzaWorldEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaWorldEurekaApplication.class, args);
	}

}
