package model;

public class Schedule {
	private char day;
	private String startTime;
	private String endTime;
	private String DoctorName;
	
	
	public Schedule(char day, String startTime, String endTime,String doctorname) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.DoctorName = doctorname;
	}
	
	public String getDoctorname()
	{
		return DoctorName;
	}
	
	public char getDay()
	{
		return day;
	}
	
	public String getEndtime()
	{
		return endTime;
	}
	
	public String getStarttime()
	{
		return startTime;
	}
	
}
