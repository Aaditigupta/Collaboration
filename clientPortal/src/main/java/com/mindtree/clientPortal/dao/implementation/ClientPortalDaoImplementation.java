package com.mindtree.clientPortal.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.mindtree.clientPortal.entity.Client;
import com.mindtree.clientPortal.entity.Company;
import com.mindtree.clientPortal.exception.dao.ClientPortalDaoException;
import com.mindtree.clientPortal.utility.DbUtil;

public class ClientPortalDaoImplementation {
	static DbUtil du = new DbUtil();
	static Company company = new Company();

	public Company sendDetailsToDao(Client client, int id) {
		// boolean isInserted = false;
		Set<Client> clients = new HashSet<Client>();
		Connection con = du.getConnection();
		ResultSet rs = null;
		String query = "insert into client(client_id,client_name,client_budget,company_id) values(?,?,?,?)";
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, client.getClientId());
			statement.setString(2, client.getClientName());
			statement.setInt(3, client.getClientBudget());
			statement.setInt(4, id);
			statement.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query4 ="select company.company_id,company.company_name,client_id,client_name,client_budget from company inner join client on company.company_id=client.company_id";
		try {
			PreparedStatement statement = con.prepareStatement(query4);
			rs = statement.executeQuery();
			while (rs.next()) {
				int companyid = rs.getInt(1);
				String companyname = rs.getString(2);
				int clientid = rs.getInt(3);
				String cname = rs.getString(4);
				int budget = rs.getInt(5);
			    client = new Client(clientid, cname, budget, companyid);
				clients.add(client);
				company=new Company(companyid, companyname, clients);
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	public Set<Client> sendIdToDao(int id) {

		Connection con = du.getConnection();
		Set<Client> clients = new HashSet<Client>();
		ResultSet rs = null;
		String query2 = "select * from client where company_id='" + id + "'";
		try {
			PreparedStatement statement = con.prepareStatement(query2);
			rs = statement.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt(1);
				String name = rs.getString(2);
				int budget = rs.getInt(3);
				int uid = rs.getInt(4);
				Client client = new Client(cid, name, budget, uid);
				clients.add(client);
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	public boolean updateInDao(int id, int budget) {
		Connection con = du.getConnection();
		String query3 = "update client set client_budget='" + budget + "' where client_id='" + id + "'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query3);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	public ArrayList<Integer> getAllIds() throws ClientPortalDaoException {

		ArrayList<Integer> ids = new ArrayList<Integer>();
		Connection con = du.getConnection();
		ResultSet rs = null;
		String query4 = "select client_id from client";
		try {
			PreparedStatement statement = con.prepareStatement(query4);
			rs = statement.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt(1);
				ids.add(cid);
				con.close();
			}
		} catch (SQLException e) {
			throw new ClientPortalDaoException("No such client found");
		}
		return ids;
	}

	public ArrayList<Integer> getAllCompanyIds() throws ClientPortalDaoException {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		Connection con = du.getConnection();
		ResultSet rs = null;
		String query5 = "select company_id from client";
		try {
			PreparedStatement statement = con.prepareStatement(query5);
			rs = statement.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt(1);
				ids.add(cid);
				con.close();
			}
		} catch (SQLException e) {
			throw new ClientPortalDaoException("No such company found exception");
		}
		return ids;
	}
}
