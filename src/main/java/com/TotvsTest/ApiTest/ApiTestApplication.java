package com.TotvsTest.ApiTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApiTestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext=
				SpringApplication.run(ApiTestApplication.class, args);

	}

}
