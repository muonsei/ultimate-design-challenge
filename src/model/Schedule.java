package model;

public class Schedule {
	private char day;
	private String startTime;
	private String endTime;
	
	public Schedule(char day, String startTime, String endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
