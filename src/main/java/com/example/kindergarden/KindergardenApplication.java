package com.example.kindergarden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KindergardenApplication {

	public FileHandler fileHandler = new FileHandler();

	public static void main(String[] args) {
		SpringApplication.run(KindergardenApplication.class, args);
	}
}
