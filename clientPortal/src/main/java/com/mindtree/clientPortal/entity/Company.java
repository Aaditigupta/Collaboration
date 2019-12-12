package com.mindtree.clientPortal.entity;

import java.util.Set;

public class Company {
	private int companyId;
	private String companyName;
	private Set<Client> clients;

	public Company() {

	}

	public Company(int companyId, String companyName, Set<Client> clients) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.clients = clients;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
