package com.cg.product.productCartManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cg.product.productRepo")
@EntityScan("com.cg.product.bean")
@ComponentScan("com.cg.product")
public class ProductCartManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCartManagementApplication.class, args);
	}
}
