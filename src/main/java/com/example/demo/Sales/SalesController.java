package com.example.demo.Sales;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SalesController {


   Logger logger = LoggerFactory.getLogger(SalesController.class);
	   
	@Autowired
	private SalesService saleService;
		
	@RequestMapping("/Sales/{id}")
	public Sales viewSale(@PathVariable("id") int id){
		Sales sale=saleService.getSaleById(id);
		if(sale!=null){
			return sale;
		}
		else{
			return null ; 
		}
	}
		
	//add new Sale -------------------------------------------------------
	 	
	@RequestMapping(method = RequestMethod.POST , value="/Sales/addSale")
	public void addNewSale(@RequestBody  Sales sale) {
		System.out.println("posted to /Sales/addSale");
		saleService.addSale(sale);
	}
	
	
	//get All Sale ------------------------------------------------------
	@RequestMapping(method = RequestMethod.GET , value="/Sales/all")
	public List<Sales> ShowAllSales() {
		List<Sales> allSales=saleService.GetAllSales();
		return allSales; 
	}
	
	// update Sale--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.POST , value="/Sales/update")
	public void UpdateSale(@RequestBody Sales sale){
		logger.info("Before Starting update operation");
		saleService.updateSale(sale);
		logger.info("new price :", sale.getPrice());
		logger.info("new quantities :", sale.getQuantities());
	}
}



