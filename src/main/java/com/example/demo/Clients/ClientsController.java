package com.example.demo.Clients;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ClientsController {


	@Autowired
	private ClientsService clientService;
		
	@RequestMapping("/Clients/{id}")
	public Clients viewClient(@PathVariable("id") int id){
		Clients client=clientService.getClientById(id);
		if(client!=null){
			return client;
		}
		else{
			return null ; 
		}
	}
		
	//add new client -------------------------------------------------------
	 	
	@RequestMapping(method = RequestMethod.POST , value="/Clients/addClient")
	public void addNewClient(@RequestBody  Clients client) {
		System.out.println("posted to /Clients/addClient");
		clientService.addClient(client);
	}
	
	
	//get All client ------------------------------------------------------
	@RequestMapping(method = RequestMethod.GET , value="/Clients/all")
	public List<Clients> ShowAllClients() {
		List<Clients> allClients=clientService.GetAllClients();
		return allClients; 
	}
	
	// update client--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.POST , value="/Clients/update")
	public void UpdateClient(@RequestBody Clients client){
		System.out.println("posted to /Clients/update ");
		clientService.updateClient(client);
	}
}



