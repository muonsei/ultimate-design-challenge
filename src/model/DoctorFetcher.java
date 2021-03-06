package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class DoctorFetcher implements I_Fetcher {
	private DBConnection connection;
	
	public DoctorFetcher() {
		connection = new DBConnection();
		connection.getConnection();
	}
	
	@Override
	public ArrayList<Doctor> getAll() {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM doctor ORDER BY doctor_name";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Doctor doctor = toObject(rs);
				doctorList.add(doctor);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return doctorList;
	}

	@Override
	public ArrayList<Doctor> getBySearch(String keyword) {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM doctor WHERE doctor_name LIKE '%" + keyword + "%'" +
					" ORDER BY doctor_name";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Doctor doctor = toObject(rs);
				doctorList.add(doctor);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return doctorList;
	}
	
	public Doctor getByExactName(String keyword) {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM doctor WHERE doctor_name = '" + keyword +
					"' ORDER BY doctor_id";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Doctor doctor = toObject(rs);
				doctorList.add(doctor);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if (!doctorList.isEmpty())
			return doctorList.get(0);
		
		return null;
	}
	
	public Doctor getByID(int id) {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM doctor WHERE doctor_id = " + id +
					" ORDER BY doctor_id";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Doctor doctor = toObject(rs);
				doctorList.add(doctor);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if (!doctorList.isEmpty())
			return doctorList.get(0);
		
		return null;
	}
	
	public Doctor ifExists(String name) {
		Doctor doctor = getByExactName(name);
		return doctor;
	}

	@Override
	public Doctor toObject(ResultSet rs) throws SQLException {
		Doctor doctor = new Doctor(rs.getInt("doctor_id"), rs.getString("doctor_name"), rs.getInt("doctor_red"),
				rs.getInt("doctor_green"), rs.getInt("doctor_blue"));
		AppointmentFetcher af = new AppointmentFetcher();
		ScheduleFetcher sf = new ScheduleFetcher();
		ArrayList<Appointment> appointmentList = af.getByDoctor(doctor.getDoctorName());
		ArrayList<Schedule> scheduleList = sf.getBySearch(doctor.getDoctorName());
		doctor.setAppointmentList(appointmentList);
		doctor.setScheduleList(scheduleList);
		return doctor;
	}
}
