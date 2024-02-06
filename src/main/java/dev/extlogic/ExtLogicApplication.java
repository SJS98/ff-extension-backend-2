package dev.extlogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExtLogicApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExtLogicApplication.class, args);
//		new StepGeneratorService();

    }
}