package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DBConnection;

public class ScheduleManager implements I_Manager{

	private DBConnection connection;
	
	public ScheduleManager()
	{
		connection = new DBConnection();
	}
	
	public boolean add(Object s)
	{
		String query = "INSERT INTO schedule (doctor_id,schedule_name,day,from_time,to_time) VALUES(?,?,?)";
		PreparedStatement statement;
		DoctorFetcher df = new DoctorFetcher();
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setInt(1, df.getByExactName(((Schedule) s).getDoctorname()).getDoctorID());
			statement.setString(2, ((Schedule) s).getSchedname());
			statement.setString(3, String.valueOf(((Schedule) s).getDay()));
			statement.setString(4, ((Schedule) s).getStarttime());
			statement.setString(5, ((Schedule) s).getEndtime());
			
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	public boolean remove(Object s)
	{
		
		String query = "DELETE FROM schedule WHERE sched_id = ?;";
		PreparedStatement statement;
		ScheduleFetcher sf = new ScheduleFetcher();
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setInt(1, sf.getSchedID(((Schedule) s).getEndtime(), ((Schedule) s).getStarttime(), ((Schedule) s).getDay()));
			
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public boolean modifySchedule(Schedule s)
	{
		
		String query = "UPDATE schedule SET to_time = ? AND from_time=? AND schedule_name=? WHERE sched_id = ?;";
		PreparedStatement statement;
		ScheduleFetcher sf = new ScheduleFetcher();
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, s.getEndtime());
			statement.setString(2, s.getStarttime());
			statement.setString(3, s.getSchedname());
			statement.setInt(4, sf.getSchedID(((Schedule) s).getEndtime(), ((Schedule) s).getStarttime(), 
					String.valueOf(((Schedule) s).getDay()).charAt(0)));
			
			
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}	
	
}
