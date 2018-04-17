package com.api.finra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.api"})
public class FinraTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinraTestApplication.class, args);
	}
}
