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
		String query = "INSERT INTO schedule (doctor_id,day,from_time,to_time) VALUES(?,?,?,?)";
		PreparedStatement statement;
		DoctorFetcher df = new DoctorFetcher();
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setInt(1, df.getByExactName(((Schedule) s).getDoctorname()).getDoctorID());
			statement.setString(2, String.valueOf(((Schedule) s).getDay()));
			statement.setString(3, ((Schedule) s).getStarttime());
			statement.setString(4, ((Schedule) s).getEndtime());
			
			
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
		
		String query = "UPDATE schedule SET to_time = ?, from_time=? WHERE sched_id = ?;";
		PreparedStatement statement;
		ScheduleFetcher sf = new ScheduleFetcher();
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, s.getEndtime());
			statement.setString(2, s.getStarttime());
			statement.setInt(3, sf.getSchedID(((Schedule) s).getEndtime(), ((Schedule) s).getStarttime(), 
					String.valueOf(((Schedule) s).getDay()).charAt(0)));
			
			
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}	
	
}
