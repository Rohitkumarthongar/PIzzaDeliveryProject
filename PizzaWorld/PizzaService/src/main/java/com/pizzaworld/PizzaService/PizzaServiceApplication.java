package com.pizzaworld.PizzaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PizzaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaServiceApplication.class, args);
	}

}
