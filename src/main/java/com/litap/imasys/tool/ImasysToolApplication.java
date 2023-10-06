package com.litap.imasys.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
@EnableCaching
public class ImasysToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImasysToolApplication.class, args);
		System.out.println("IMASYS app is runing");
	}

}
