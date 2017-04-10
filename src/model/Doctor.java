package model;

import java.util.ArrayList;

public class Doctor {
	private int doctorID;
	private String doctorName;
	private ArrayList<Appointment> appointmentList;
	private ArrayList<Schedule> scheduleList;
	private int[] color = new int[3];
	
	public Doctor(int doctorID, String doctorName, int red, int green, int blue) {
		this.doctorName = doctorName;
		color[0] = red;
		color[1] = green;
		color[2] = blue;
	}
	
	public int getDoctorID() {
		return doctorID;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	
	public void setDoctorName(String n) {
		doctorName = n;
	}
	
	public void setAppointmentList(ArrayList<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	
	public void setScheduleList(ArrayList<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	public void setDoctorColor(int red, int green, int blue) {
		color[0] = red;
		color[1] = green;
		color[2] = blue;
	}
	
	public int[] getDoctorColor() {
		return color;
	}
	
	public ArrayList<Appointment> getAppointments() {
		return appointmentList;
	}
	
	public ArrayList<Schedule> getSchedules() {
		return scheduleList;
	}
}
