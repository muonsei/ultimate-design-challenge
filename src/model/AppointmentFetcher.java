package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AppointmentFetcher implements I_Fetcher {
	/* Hello to whoever's reading this code rn.
	 * This is NOT YET FINAL.
	 * BUT THIS IS THE LATEST CODE :P
	 * 
	 * -Jo
	 */
	
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
					+ "AND client.client_name LIKE '%" + keyword + "%'" +
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
					+ "AND doctor.doctor_name LIKE '%" + keyword + "%'" +
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
	
	public ArrayList<Appointment> getByClient(String keyword) {
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		try {
			ResultSet rs;
			String query = "SELECT appointment.time, appointment.date FROM appointment, client WHERE appointment.client_id = client.client_id "
					+ "AND client.client_name LIKE '%" + keyword + "%'" +
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
	
	public ArrayList<Appointment> getByDoctorID(int doctorID) {
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		try {
			ResultSet rs;
			String query = "SELECT appointment.time, appointment.date FROM appointment, doctor WHERE appointment.doctor_id = " + doctorID
					+ " ORDER BY doctor_id";
			
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
	
	public int getAppointmentID(String to_time, String from_time, String date) {
		int appointID=0;
		
		try {
			ResultSet rs;
			String query = "SELECT appointment.appointment_id FROM appointment WHERE appointment.to_time = " + to_time
					+ "AND appointment.from_time = " + from_time + "AND appointment.date = " + date + " ORDER BY appointment.appointment_id";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				appointID = rs.getInt("appointment_id");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return appointID;
	}
	
	public ArrayList<Appointment> getByClientID(int clientID) {
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		try {
			ResultSet rs;
			String query = "SELECT appointment.time, appointment.date FROM appointment, client WHERE appointment.client_id = " + clientID
					+ " ORDER BY client_id";
			
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
		Appointment appointment = new Appointment(rs.getString("appointment_date"),rs.getString("appointment_from_time"),rs.getString("appointment_to_time"),rs.getString("appointment_clientname"));
		return appointment;
	}
}
