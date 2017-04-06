package model;

import java.util.ArrayList;

public class Doctor {
	private String doctorName;
	private ArrayList<Appointment> appointmentList;
	
	public Doctor(String doctorName){
		this.doctorName = doctorName;
		appointmentList = new ArrayList<Appointment>();
	}
}
