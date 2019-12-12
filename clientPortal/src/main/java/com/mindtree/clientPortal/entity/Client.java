package com.mindtree.clientPortal.entity;

public class Client {
private int clientId;
private String clientName;
private int clientBudget;
private int companyID;

public Client() {
	
}

public Client(int clientId, String clientName, int clientBudget, int companyID) {
	super();
	this.clientId = clientId;
	this.clientName = clientName;
	this.clientBudget = clientBudget;
	this.companyID = companyID;
}

public int getCompanyID() {
	return companyID;
}

public void setCompanyID(int companyID) {
	this.companyID = companyID;
}

public int getClientId() {
	return clientId;
}
public void setClientId(int clientId) {
	this.clientId = clientId;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
public int getClientBudget() {
	return clientBudget;
}
public void setClientBudget(int clientBudget) {
	this.clientBudget = clientBudget;
}

}
