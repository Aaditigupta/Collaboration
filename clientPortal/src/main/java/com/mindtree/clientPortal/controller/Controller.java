package com.mindtree.clientPortal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.clientPortal.entity.Client;
import com.mindtree.clientPortal.entity.Company;
import com.mindtree.clientPortal.exception.service.ClientPortalServiceException;
import com.mindtree.clientPortal.service.Implementation.ClientPortalServiceImplementation;

@RestController
public class Controller {
	
	@PostMapping("/sendData/{id}")
	public Company sendDetailsToService(@RequestBody Client client, @PathVariable int id) {
		//boolean isSent = false;
		Company company=new Company();
		company = ClientPortalServiceImplementation.sendDetailsToService(client, id);
			System.out.println("Successfully added!!!");
			return company;
	}

	@GetMapping("/getData/{id}")
	public Set<Client> getAllDetailsFromService(@PathVariable int id) {
		Set<Client> clients = new HashSet<Client>();
		try {
		clients = ClientPortalServiceImplementation.sendIdToService(id);
		}catch(ClientPortalServiceException e) {
			System.out.println(e.getMessage());
		}
		return clients;

	}

	@PutMapping("/update/{id}/{budget}")
	public boolean updateid(@PathVariable int id, @PathVariable int budget) {
		boolean isUpdated = false;
		try {
			isUpdated = ClientPortalServiceImplementation.updateData(id, budget);
		} catch (ClientPortalServiceException e) {
			System.out.println(e.getMessage());
		}
		if (isUpdated == true) {
			System.out.println("Updated!!!!!!");
		} else {
			System.out.println("Not Updated");
		}
		return isUpdated;
	}
}
