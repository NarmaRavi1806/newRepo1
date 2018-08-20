package com.cg.product.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EnableJpaRepositories({"hibernateLazyInitializer","handler"})
@JsonIgnoreProperties
@Entity
public class Product {
	@Id
	private String productCode;
	private String name;
	private double price;
	private String description;
	private String manufactureDate;

	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Product() {
		super();
	}




}
