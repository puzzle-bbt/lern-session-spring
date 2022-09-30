package com.example.springrestdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ExampleProperties.class)
public class SpringRestDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDbApplication.class, args);
	}

}
