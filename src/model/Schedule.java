package model;

public class Schedule {
	private char day;
	private String startTime;
	private String endTime;
	private String scheduleName;
	
	public Schedule(String scheduleName, char day, String startTime, String endTime) {
		this.scheduleName = scheduleName;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
