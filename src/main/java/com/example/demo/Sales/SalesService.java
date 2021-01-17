package com.example.demo.Sales;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SalesService {

	@Autowired
	private SalesRepository saleRepository;
	
	public List<Sales> GetAllSales() {
		List<Sales> sales=saleRepository.findAll();
		return sales;
	}
	
	public void addSale(Sales sale)
	{
		saleRepository.save(sale);
	}


	public Sales getSaleById(int id)
	{
		List<Sales> allSales = this.saleRepository.findAll() ; 
		if(allSales.isEmpty()) {
			System.out.println("empty Sales List ");
			return null ;  
		}
		for(Sales sale : allSales) {
			if(sale.getSaleID() == id ){
				return sale ; 
			}
		}
		System.out.println("requested sale not found ");
		return null ; 
	 
	}

	public void updateSale(Sales sale) {
		try {
			if(saleRepository.findById(sale.getSaleID()) != null) {
					saleRepository.save(sale); 
				}
		}catch(Exception e ) {
			System.out.println("NullPointerException Handled at sale Service / Update sale -- call for null Client ");
		}
	}	
}
