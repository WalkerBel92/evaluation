package com.bbeltranl.evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to start the Spring Boot application.
 * <p>
 * This class initializes and starts the Spring Boot application using the {@link SpringApplication} class.
 * It is annotated with {@link SpringBootApplication} to enable auto-configuration, component scanning, and
 * to indicate that it's the main entry point of the application.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-06-13
 */
@SpringBootApplication
public class EvaluationApplication {

	/**
	 * Main method to start the Spring Boot application.
	 *
	 * @param args the command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EvaluationApplication.class, args);
	}

}
