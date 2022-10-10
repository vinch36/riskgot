package com.vinch36.riskgot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RiskgotApplication {
	public static long startTime;

	public static void main(String[] args) {
		startTime = System.currentTimeMillis();
		System.out.println("WELCOME TO RISK GOT SERVER - STARTING SERVER MIGHT TAKE SOME TIME");
		SpringApplication.run(RiskgotApplication.class, args);
		System.out.println("RISK GOT SERVER STARTED ! ENJOY");

	}

}
