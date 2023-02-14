package com.moreirajunior.PersonAPI;

import com.moreirajunior.PersonAPI.appLogger.AppLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class PersonApiApplication {

	private static final Logger LOGGER = AppLogger.getAppLogger();

	public static void main(String[] args) {
		SpringApplication.run(PersonApiApplication.class, args);
		LOGGER.info("Application started!");
	}

}
