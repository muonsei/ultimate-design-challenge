package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class ClientFetcher implements I_Fetcher {
	private DBConnection connection;
	
	public ClientFetcher() {
		connection = new DBConnection();
		connection.getConnection();
	}
	
	@Override
	public ArrayList<Client> getAll() {
		ArrayList<Client> clientList = new ArrayList<Client>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM client ORDER BY client_name";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Client client = toObject(rs);
				clientList.add(client);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return clientList;
	}

	@Override
	public ArrayList<Client> getBySearch(String keyword) {
		ArrayList<Client> clientList = new ArrayList<Client>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM client WHERE client_name LIKE %" + keyword + "%" +
					" ORDER BY client_name";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Client client = toObject(rs);
				clientList.add(client);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return clientList;
	}
	
	public Client getByExactName(String keyword) {
		ArrayList<Client> clientList = new ArrayList<Client>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM client WHERE client_name = " + keyword +
					" ORDER BY client_id";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Client client = toObject(rs);
				clientList.add(client);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if (!clientList.isEmpty())
			return clientList.get(0);
		
		return null;
	}
	
	public Client getByID(int id) {
		ArrayList<Client> clientList = new ArrayList<Client>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM client WHERE client_id = " + id +
					" ORDER BY client_id";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Client client = toObject(rs);
				clientList.add(client);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if (!clientList.isEmpty())
			return clientList.get(0);
		
		return null;
	}
	
	public Client ifExists(String name) {
		Client client = getByExactName(name);
		return client;
	}

	@Override
	public Client toObject(ResultSet rs) throws SQLException {
		Client client = new Client(rs.getInt("client_id"), rs.getString("client_name"));
		
		return client;
	}
}