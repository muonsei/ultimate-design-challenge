package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DBConnection;

public class DoctorManager implements I_Manager{

	private static DBConnection connection;
	
	public DoctorManager()
	{
		connection = new DBConnection();
	}
	
	public boolean add(Object d)
	{
		String query = "INSERT INTO doctor (doctor_name) VALUES(?)";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, ((Doctor)d).getDoctorName());
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean remove(Object d)
	{
		
		String query = "DELETE FROM doctor WHERE doctor_name = ?;";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1,((Doctor) d).getDoctorName());
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public boolean modifyName(Object d)
	{
		
		String query = "UPDATE doctor SET doctor_name = ? WHERE doctor_name = ?;";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, "Kate2");	
			statement.setString(2, ((Doctor)d).getDoctorName());
			
			
			((Doctor)d).setDoctorName("Kate2");
				
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
}
