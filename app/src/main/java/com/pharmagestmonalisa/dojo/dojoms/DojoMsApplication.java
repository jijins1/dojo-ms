package com.pharmagestmonalisa.dojo.dojoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pharmagest.monalisa.dojo.core")
public class DojoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojoMsApplication.class, args);
	}

}
