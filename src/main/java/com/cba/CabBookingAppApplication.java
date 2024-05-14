package com.cba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableJpaAuditing
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@EnableSwagger2
public class CabBookingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CabBookingAppApplication.class, args);
        System.out.println("Spring Boot application Cab booking running ");
    }

}
