package com.bankingapp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BankingAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}


	/*
	 * To allow cross-origin requests from the frontend (e.g., React app running on localhost:5173)
	 * to the backend (Spring Boot app), we need to configure CORS settings.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:5173");
			}
		};
	}
}
