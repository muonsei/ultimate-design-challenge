package model;

import java.util.ArrayList;

public class Client {
	private String clientName;
	private ArrayList<Appointment> appointmentList;
	
	public Client(String clientName) {
		this.clientName = clientName;
		appointmentList = new ArrayList<Appointment>();
	}
}
