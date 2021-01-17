package com.example.demo.Products;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductsController {


	@Autowired
	private ProductsService productService;
		
	@RequestMapping("/Products/{id}")
	public Products viewProduct(@PathVariable("id") int id){
		Products product=productService.getProductById(id);
		if(product!=null){
			return product;
		}
		else{
			return null ; 
		}
	}
		
	
	//add new Product -------------------------------------------------------
	 	
	@RequestMapping(method = RequestMethod.POST , value="/Products/addProduct")
	public void addNewBank(@RequestBody  Products product) {
		System.out.println("posted to /Products/addProduct ");
		productService.addProduct(product);
	}
	
	
	//get All Products ------------------------------------------------------
	@RequestMapping(method = RequestMethod.GET , value="/Products/all")
	public List<Products> ShowAllProducts() {
		List<Products> allProducts=productService.GetAllProducts();
		return allProducts; 
	}
	
	// update Product--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.POST , value="/Banks/update")
	public void UpdateBank(@RequestBody Products product) {
		System.out.println("posted to /Products/update ");
		productService.updateProduct(product);
	}
}



