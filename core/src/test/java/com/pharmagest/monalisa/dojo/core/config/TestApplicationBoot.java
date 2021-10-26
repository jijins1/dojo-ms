package com.pharmagest.monalisa.dojo.core.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication()
@Import(CoreConfig.class)
public class TestApplicationBoot {
    public static void main(String[] args) {
        SpringApplication.run(TestApplicationBoot.class, args);
    }
    
}
