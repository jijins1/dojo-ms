package com.pharmagest.monalisa.dojo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pharmagest.monalisa.dojo.core.config.CoreConfig;

@SpringBootApplication(
        scanBasePackageClasses = {CoreConfig.class},
        scanBasePackages = {
                "com.pharmagest.monalisa.dojo.app.mapper",
                "com.pharmagest.monalisa.dojo.app.controller",
                "com.pharmagest.monalisa.dojo.app.config"
        }
)
public class DojoMsApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DojoMsApplication.class, args);
    }
    
}
