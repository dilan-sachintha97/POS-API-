package com.batch80.pointofsalebatch80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PointOfSaleBatch80Application {

	public static void main(String[] args) {
		SpringApplication.run(PointOfSaleBatch80Application.class, args);
	}

}
