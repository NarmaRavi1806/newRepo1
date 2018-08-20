package com.cg.product.productService;

import java.util.List;

import com.cg.product.bean.Product;
import com.cg.product.productException.ProductException;

public interface IProductService {

	Product addProduct(Product product) throws ProductException;

	List<Product> viewAllProducts(Product product) throws ProductException;

	/*Product updateProduct(Product product) throws ProductException;

	boolean deleteProduct(String id) throws ProductException;*/

	Product getProductById(String id) throws ProductException;

}
