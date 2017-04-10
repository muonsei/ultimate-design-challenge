package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Database.DBConnection;

public class AppointmentManager implements I_Manager{
	
private static DBConnection connection;
	
	public AppointmentManager()
	{
		connection = new DBConnection();
	}
	
	public boolean add(Object a)
	{
		String query = "INSERT INTO appointment (appointment_id,client_id,Doctor_id,time,date) VALUES(?,?,?,?,?)";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, "11");
			statement.setString(2, "22");
			statement.setString(3, "33");
			statement.setString(4, "330");
			statement.setString(5, "530");
			//Replace above statement.setString(1, d.getdoctorName);
			
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean remove(Object a)
	{
		
		String query = "DELETE FROM appointment WHERE appointment_id = ? AND client_id = ? AND doctor_id = ? AND time = ? AND date = ?;";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, "11");
			statement.setString(2, "22");
			statement.setString(3, "33");
			statement.setString(4, "330");
			statement.setString(5, "530");
			//Replace above statement.setString(1, d.getdoctorName);
			
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public boolean modifyAppointment(Appointment a)
	{
		
		String query = "UPDATE appointment SET time = ?, date = ? WHERE appointment_id = ? AND client_id = ? AND doctor_id = ? AND time = ? AND date = ?;";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, "630");
			//Replace above statement.setString(1, d.getdoctorName);
			statement.setString(2, "700");
			//Replace above "new name";
			statement.setString(3, "11");
			statement.setString(4, "22");
			statement.setString(5, "33");
			statement.setString(6, "630");
			statement.setString(7, "530");
				
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
}
