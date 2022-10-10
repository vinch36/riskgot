package com.vinch36.frontendjava;

import com.vinch36.frontendjava.configuration.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontendJavaApplication implements CommandLineRunner {

	@Autowired
	private CustomProperties properties;

	public static void main(String[] args) {

		SpringApplication.run(FrontendJavaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("URL of backend is configured as: " + properties.getApiUrl());
	}
}
