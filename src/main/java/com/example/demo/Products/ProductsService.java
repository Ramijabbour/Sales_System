package com.example.demo.Products;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productRepository;
	
	public List<Products> GetAllProducts() {
		List<Products> products=productRepository.findAll();
		return products;
	}
	
	public void addProduct(Products product)
	{
		productRepository.save(product);
	}


	public Products getProductById(int id)
	{
		List<Products> allProducts = this.productRepository.findAll() ; 
		if(allProducts.isEmpty()) {
			System.out.println("empty Product List ");
			return null ;  
		}
		for(Products product : allProducts) {
			if(product.getProductID() == id ){
				return product ; 
			}
		}
		System.out.println("requested product not found ");
		return null ; 
	 
	}

	public void updateProduct(Products product) {
		try {
			if(productRepository.findById(product.getProductID()) != null) {
					productRepository.save(product); 
				}
		}catch(Exception e ) {
			System.out.println("NullPointerException Handled at Product Service / Update Product -- call for null Product ");
		}
	}	
}
