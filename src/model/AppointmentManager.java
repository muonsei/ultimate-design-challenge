package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DBConnection;

public class AppointmentManager implements I_Manager{
	
private static DBConnection connection;
	
	public AppointmentManager()
	{
		connection = new DBConnection();
	}
	
	public boolean add(Object a)
	{
		//date and time base ng doctor id
		String query = "INSERT INTO appointment (client_id,doctor_id,to_time,from_time,date) VALUES(?,?,?,?)";
		PreparedStatement statement;
		DoctorFetcher df = new DoctorFetcher();
		ClientFetcher cf = new ClientFetcher();
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setInt(1, cf.getByExactName(((Appointment)a).getClientName()).getClientID());
			//statement.setInt(2, df.);
			statement.setString(3, ((Appointment)a).getToTime());
			statement.setString(4, ((Appointment)a).getFromTime());
			statement.setString(5, ((Appointment)a).getDate());
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean remove(Object a)
	{
		
		String query = "DELETE FROM appointment WHERE appointment_id = ?";
		PreparedStatement statement;
		ClientFetcher cf = new ClientFetcher();
		AppointmentFetcher af = new AppointmentFetcher();
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setInt(1, af.getAppointmentID(((Appointment) a).getToTime(), ((Appointment) a).getFromTime(), 
					((Appointment) a).getDate()));
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public boolean modifyAppointment(Appointment a)
	{
		
		String query = "UPDATE appointment SET from_time = ?,to_time = ?, date = ? WHERE appointment_id = ?;";
		PreparedStatement statement;
		AppointmentFetcher af = new AppointmentFetcher();
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, a.getFromTime());
			statement.setString(2, a.getToTime());
			statement.setString(3, a.getDate());
			statement.setInt(4,  af.getAppointmentID(((Appointment) a).getToTime(), ((Appointment) a).getFromTime(), 
					((Appointment) a).getDate()));
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
}
