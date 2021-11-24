package com.alfabank.currence_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = {"com.alfabank.currence_project",
									"com.alfabank.currence_project.controller",
									"com.alfabank.currence_project.service"})
@EnableDiscoveryClient

public class CurrenceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrenceProjectApplication.class, args);
	}
}
