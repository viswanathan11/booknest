package com.example.booknest;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooknestApplication {

	public static void main(String[] args) {
		  TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		SpringApplication.run(BooknestApplication.class, args);

		System.out.println("Server is live on: http://localhost:8080/swagger-ui.html");
	}

}
