package com.cg.product.productService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.product.bean.Product;
import com.cg.product.productException.ProductException;
import com.cg.product.productRepo.IProductRepo;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductRepo repo;

	@Override
	@Transactional
	public Product addProduct(Product product) throws ProductException {
		if(product.getProductCode()==null || product.getProductCode().isEmpty()) {
		throw new ProductException("Id is null,Give proper id");
		}
		if(product.getName()==null || product.getName().isEmpty()) {
			throw new ProductException("Product name should not be null");
		}
		if(product.getDescription()==null || product.getDescription().isEmpty()) {
			throw new ProductException("Product model should not be null");
		}
		if(!(product.getPrice()>5000)) {
			throw new ProductException("Price should not be less than 5000");
		}
		else {
		repo.save(product);
		}
		return product;
	}

	@Override
	@Transactional
	public List<Product> viewAllProducts(Product product) throws ProductException {
		
		return repo.findAll();
	}

	/*@Override
	@Transactional
	public Product updateProduct(Product product) throws ProductException {
		Product product1=addProduct(product);
		if(product.getId()==null || product.getId().isEmpty()) {
			throw new ProductException("Id is null,Give proper id");
			}
		if(product.getName()==null || product.getName().isEmpty()) {
			throw new ProductException("Product name should not be null");
		}
		if(product.getModel()==null || product.getModel().isEmpty()) {
			throw new ProductException("Product model should not be null");
		}
		if(!(product.getPrice()>5000)) {
			throw new ProductException("Price should not be less than 5000");
		}
		else {
		product1.setId(product.getId());
		product1.setName(product.getName());
		//product1.setModel(product.getModel());
		product1.setPrice(product.getPrice());
		repo.save(product1);
			}
		return product1;
	}

	@Override
	@Transactional
	public boolean deleteProduct(String id) throws ProductException {
		Product product=repo.productDetails(id);
		if(product==null) {
			throw new ProductException("Product of Id cannot be found");
		}else {
			repo.deleteById(id);
			return true;
		}
		
	}*/

	@Override
	public Product getProductById(String id) throws ProductException {
		Product product=repo.productDetails(id);
		if(product==null) {
			throw new ProductException("Product of given productCode cannot be found");
		}
		if(id==null || id.isEmpty()) {
			throw new ProductException("productCode is null or Given productCode is not available");
		}else {
			return repo.productDetails(id);
		}
		
	}

}
