package com.mindtree.clientPortal.service.Implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.mindtree.clientPortal.dao.implementation.ClientPortalDaoImplementation;
import com.mindtree.clientPortal.entity.Client;
import com.mindtree.clientPortal.entity.Company;
import com.mindtree.clientPortal.exception.dao.ClientPortalDaoException;
import com.mindtree.clientPortal.exception.service.ClientPortalServiceException;
import com.mindtree.clientPortal.exception.service.NoClientPresentException;
import com.mindtree.clientPortal.exception.service.NoSuchClientException;
import com.mindtree.clientPortal.exception.service.NoSuchCompanyException;

public class ClientPortalServiceImplementation {
	static ClientPortalDaoImplementation dao = new ClientPortalDaoImplementation();
	static Company company = new Company();

	public static Company sendDetailsToService(Client client, int id) {
	//	boolean isSent = false;
		company = dao.sendDetailsToDao(client, id);
		return company;

	}

	public static Set<Client> sendIdToService(int id) throws ClientPortalServiceException {
		int count = 0;
		Set<Client> clients = new HashSet<Client>();
		ArrayList<Integer> clientss = null;
		clients = dao.sendIdToDao(id);
		try {
			clientss = dao.getAllCompanyIds();
			for (Integer companyId : clientss) {

				if (companyId == id) {
					count++;
				}
			}
			if (count == 0) {
				throw new NoSuchCompanyException("No such company Id found");
			}
			if(clients.size()==0) {
				throw new NoClientPresentException("no clients are found");
			}
			clients = dao.sendIdToDao(id);
		}  catch (ClientPortalDaoException e) {
			throw new ClientPortalServiceException(e);
		} 
		return clients;
	}

	public static boolean updateData(int id, int budget) throws ClientPortalServiceException {
		ArrayList<Integer> clientids = null;
		int count = 0;
		boolean isUpdated = false;
		try {
			clientids = dao.getAllIds();
			for (Integer clientid : clientids) {
				if (clientid == id) {
					count++;
				}
			}
			if (count == 0) {
				throw new NoSuchClientException("no such client found");
			}
			isUpdated = dao.updateInDao(id, budget);
		} catch (ClientPortalDaoException e) {
			throw new ClientPortalServiceException(e);
		}

		// TODO Auto-generated method stub
		return isUpdated;

	}
}
