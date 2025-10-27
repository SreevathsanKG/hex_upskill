package com.hex.ecomcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HexEcomcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexEcomcsApplication.class, args);
	}

}
