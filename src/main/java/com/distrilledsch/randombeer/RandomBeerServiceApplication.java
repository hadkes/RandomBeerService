package com.distrilledsch.randombeer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RandomBeerServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(RandomBeerServiceApplication.class);
	
	public static void main(String[] args) {
		logger.debug("Initializing random beer service application.");
		SpringApplication.run(RandomBeerServiceApplication.class, args);
	}
}
