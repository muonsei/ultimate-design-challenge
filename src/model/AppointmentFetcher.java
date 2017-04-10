package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AppointmentFetcher implements I_Fetcher {
	private DBConnection connection;
	
	public AppointmentFetcher() {
		connection = new DBConnection();
		connection.getConnection();
	}
	
	@Override
	public ArrayList<Appointment> getAll() {
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM appointment";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Appointment appointment = toObject(rs);
				appointmentList.add(appointment);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return appointmentList;
	}
	
	@Override
	public ArrayList<Appointment> getBySearch(String keyword) { //Client
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		try {
			ResultSet rs;
			String query = "SELECT appointment.time, appointment.date FROM appointment, client WHERE appointment.client_id = client.client_id "
					+ "AND client.client_name LIKE %" + keyword + "%" +
					" ORDER BY client_name";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Appointment appointment = toObject(rs);
				appointmentList.add(appointment);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return appointmentList;
	}
	
	public ArrayList<Appointment> getByDoctor(String keyword) {
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		try {
			ResultSet rs;
			String query = "SELECT appointment.time, appointment.date FROM appointment, doctor WHERE appointment.doctor_id = doctor.doctor_id "
					+ "AND doctor.doctor_name LIKE %" + keyword + "%" +
					" ORDER BY doctor_name";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Appointment appointment = toObject(rs);
				appointmentList.add(appointment);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return appointmentList;
	}
	@Override
	public Appointment toObject(ResultSet rs) throws SQLException {
		Appointment appointment = new Appointment(rs.getString("appointment_date"),rs.getString("appointment_time"));
		return appointment;
	}
}
