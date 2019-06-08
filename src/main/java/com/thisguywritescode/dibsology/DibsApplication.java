package com.thisguywritescode.dibsology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.thisguywritescode.dibsology.repository")
public class DibsApplication {

	public static void main(final String[] args) {
		SpringApplication.run(DibsApplication.class, args);
	}

}
