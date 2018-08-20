package com.cg.product.productRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.product.bean.Product;

@Repository
public interface IProductRepo extends JpaRepository<Product, String>{

	@Query("SELECT p FROM Product p WHERE p.productCode=:id")
	Product productDetails(@Param(value="id") String id);

}
