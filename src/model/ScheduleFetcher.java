package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScheduleFetcher implements I_Fetcher {
private DBConnection connection;
	
	public ScheduleFetcher() {
		connection = new DBConnection();
		connection.getConnection();
	}
	
	public int getSchedID(String to_time, String from_time, char day) {
		int schedID=0;
		
		try {
			ResultSet rs;
			String query = "SELECT schedule.sched_id FROM schedule WHERE schedule.to_time = " + to_time
					+ "AND schedule.from_time = " + from_time + "AND schedule.day = " + day + " ORDER BY schedule.sched_id";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				schedID = rs.getInt("sched_id");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return schedID;
	}
	
	
	
	@Override
	public ArrayList<Schedule> getAll() {
		ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
		
		try {
			ResultSet rs;
			String query = "SELECT * FROM schedule";
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Schedule schedule = toObject(rs);
				scheduleList.add(schedule);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return scheduleList;
	}

	@Override
	public ArrayList<Schedule> getBySearch(String doctorName) {
		ArrayList<Schedule> doctorList = new ArrayList<Schedule>();
		
		try {
			ResultSet rs;
			String query = "SELECT schedule.day, schedule.time FROM schedule, doctor WHERE "
					+ "schedule.doctor_id = doctor.doctor_id AND doctor.doctor_name LIKE "
					+ doctorName;
			
			Statement stment = connection.getConnection().createStatement();
			rs = stment.executeQuery(query);
			
			while (rs.next()) {
				Schedule schedule = toObject(rs);
				doctorList.add(schedule);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return doctorList;
	}

	@Override
	public Schedule toObject(ResultSet rs) throws SQLException {
		Schedule schedule = new Schedule(rs.getString("day").charAt(0), rs.getString("from_time"), rs.getString("to_time"),rs.getString("doctorname"));
		return schedule;
	}
}
