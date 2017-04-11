package model;

public class Appointment {
	private String date;
	private String from_time;
	private String to_time;
	private String clientname;
	
	public Appointment(String date, String from_time,String to_time,String clientname) {
		this.date = date;
		this.from_time = from_time;
		this.to_time = to_time;
		this.clientname = clientname;
	}
	
	public void setClientName(String n)
	{
		clientname = n;
	}
	
	public String getClientName()
	{
		return clientname;
	}
	
	public String getFromTime()
	{
		return from_time;
	}
	
	public String getToTime()
	{
		return to_time;
	}
	
	public String getDate()
	{
		return date;
	}
	
}
