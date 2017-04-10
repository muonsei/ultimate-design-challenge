package model;

import java.util.ArrayList;

public class Client {
	private int clientID;
	private String clientName;
	private ArrayList<Appointment> appointmentList;
	
	public Client(int clientID, String clientName) {
		this.clientID = clientID;
		this.clientName = clientName;
		appointmentList = new ArrayList<Appointment>();
	}
	
	public int getClientID() {
		return clientID;
	}
	
	public String getClientName()
	{
		return clientName;
	}
	
	public void setClientName(String n)
	{
		clientName = n;
	}
}
