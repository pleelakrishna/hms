package com.evoke.hms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.evoke.hms"})
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class HmsApplication {   
	
    public static void main(String[] args) {
        SpringApplication.run(HmsApplication.class, args);
    }
}
