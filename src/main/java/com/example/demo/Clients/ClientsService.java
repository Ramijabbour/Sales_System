package com.example.demo.Clients;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientsService {

	@Autowired
	private ClientsRepository clientRepository;
	
	public List<Clients> GetAllClients() {
		List<Clients> clients=clientRepository.findAll();
		return clients;
	}
	
	public void addClient(Clients client)
	{
		clientRepository.save(client);
	}


	public Clients getClientById(int id)
	{
		List<Clients> allClients = this.clientRepository.findAll() ; 
		if(allClients.isEmpty()) {
			System.out.println("empty Client List ");
			return null ;  
		}
		for(Clients client : allClients) {
			if(client.getClientID() == id ){
				return client ; 
			}
		}
		System.out.println("requested client not found ");
		return null ; 
	 
	}

	public void updateClient(Clients client) {
		try {
			if(clientRepository.findById(client.getClientID()) != null) {
					clientRepository.save(client); 
				}
		}catch(Exception e ) {
			System.out.println("NullPointerException Handled at Client Service / Update Client -- call for null Client ");
		}
	}	
}
