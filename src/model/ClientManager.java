package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientManager implements I_Manager{

private static DBConnection connection;
	
	public ClientManager()
	{
		connection = new DBConnection();
	}
	
	
	public boolean add(Object c)
	{
		String query = "INSERT INTO client (client_name) VALUES(?)";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1,((Client) c).getClientName());
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean remove(Object c)
	{
		
		String query = "DELETE FROM client WHERE client_name = ?;";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, ((Client)c).getClientName());
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public boolean modifyName(Object c)
	{
		
		String query = "UPDATE client SET client_name = ? WHERE client_name = ?;";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, "Kate2");
			
			statement.setString(2,((Client)c).getClientName());
				
			((Client) c).setClientName("Kate2");
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
}
