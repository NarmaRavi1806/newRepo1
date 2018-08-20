package com.cg.product.productCartManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.product.bean.Product;
import com.cg.product.productException.ProductException;
import com.cg.product.productService.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@RequestMapping(method=RequestMethod.GET,value= {"/sayHello"},produces= {"application/text"})
	public ResponseEntity<String> getHelloMessage(){
		return new ResponseEntity<String>("Hello World from REST controller",HttpStatus.OK);
	}
	
	@RequestMapping(value="/acceptProductDetails",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Product> acceptProductDetails(@ModelAttribute Product product) throws ProductException{
		//service.addProduct(product);
		return new ResponseEntity<Product>(service.addProduct(product),HttpStatus.OK);
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) throws ProductException{
		try {
		service.addProduct(product);
		}catch(ProductException p) {
			throw p;
		}
		
		return product;
		
	}
	
	@RequestMapping(value="/products")
	public List<Product> viewAllProducts(Product product) throws ProductException{
		
		
		return service.viewAllProducts(product);
		
	}
	
	/*@RequestMapping(value="/products/{id}",method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) throws ProductException{
		Product product1=null;
		try {
			product1=service.updateProduct(product);
		}catch (ProductException e) {
			throw e;
		}
		
		return product1;
		
	}*/
	
	/*@RequestMapping(value="/deleteProduct",method=RequestMethod.DELETE)
	public boolean deleteProduct(String id) throws ProductException{
		boolean b = false;
		try {
			b = service.deleteProduct(id);
		} catch (ProductException p) {
			throw p;
		}
			return b;
		
	}*/
	
	@RequestMapping(value="/findbyid")
	public Product getProductById(String id) throws ProductException{
		
		Product product1=null;
		try {
			product1 = service.getProductById(id);
		} catch (ProductException p) {
			throw p;
		}
		return product1;
		
	}

}
