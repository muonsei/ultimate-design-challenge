package controller;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import view.LoginPage;

public class AppointmentProgram
{
	public ObserverModule doctorDashboard;
	public ObserverModule secretaryDashboard;
	public ObserverModule clientDashboard;

	public JFrame mainFrame;
	public Container mainPane;
	public LoginPage login;

	public AppointmentProgram()
	{
		mainFrame = new JFrame("Desparatus Hospitium");
		mainFrame.setSize(1000, 580);
		mainPane = mainFrame.getContentPane();
		mainPane.setLayout(null);
		mainPane.setBackground(new Color(244, 249, 247));
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		login = new LoginPage();
		doctorDashboard = new DoctorModule('d', "Rodrigo Duterte");

		mainPane.add(doctorDashboard.launchFrame());

		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}
}