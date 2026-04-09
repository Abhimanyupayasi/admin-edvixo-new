package com.example.edadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EdadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdadminApplication.class, args);
		System.out.println("DB URL: " + System.getenv("DB_URL"));
	}

}
