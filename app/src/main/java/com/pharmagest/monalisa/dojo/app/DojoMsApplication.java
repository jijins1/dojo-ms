package com.pharmagest.monalisa.dojo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.pharmagest.monalisa.dojo.core.config.CoreConfig;

@Import(CoreConfig.class)
@SpringBootApplication(
        
        scanBasePackages = {
                "com.pharmagest.monalisa.dojo.app.mapper",
                "com.pharmagest.monalisa.dojo.app.controller"
        }
)
public class DojoMsApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DojoMsApplication.class, args);
    }
    
}
