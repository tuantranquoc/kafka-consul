package com.example.tiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan
@EnableDiscoveryClient
public class TikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TikiApplication.class, args);
	}

}
