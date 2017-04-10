package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.DBConnection;

public class ScheduleManager implements I_Manager{

	private DBConnection connection;
	
	public ScheduleManager()
	{
		connection = new DBConnection();
	}
	
	public boolean add(Object s)
	{
		String query = "INSERT INTO schedule (doctor_id,day, time) VALUES(?,?,?)";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			//statement.setString(1, );
			//statement.setString(2, );
			//statement.setString(3, );
			
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	public boolean remove(Object s)
	{
		
		String query = "DELETE FROM schedule WHERE sched_id = ? AND doctor_id = ? AND doctor_sched = ?;";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, "1");
			//Replace above statement.setString(1, d.getSched_id);
			statement.setString(2, "2");
			//Replace above statement.setString(1, d.getDoctor_id);
			statement.setString(3, "3");
			//Replace above statement.setString(1, d.getdoctorSched);
			
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public boolean modifySchedule(Schedule s)
	{
		
		String query = "UPDATE schedule SET doctor_sched = ? WHERE sched_id = ? AND doctor_id = ? AND doctor_sched = ?;";
		PreparedStatement statement;
		
		try{
			statement = (PreparedStatement) connection.getConnection().prepareStatement(query);
			statement.setString(1, "updated");
			//Replace above statement.setString(1, "updated sched");
			statement.setString(2, "11");
			//Replace above statement.setString(1, d.getSched_id);
			statement.setString(3, "2");
			//Replace above statement.setString(1, d.getDoctor_id);
			statement.setString(4, "3");
			//Replace above statement.setString(1, d.getdoctorSched);
					
			statement.execute();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}	
	
}
