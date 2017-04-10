package controller;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import model.Client;
import model.ClientFetcher;
import model.Doctor;
import model.DoctorFetcher;

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
		//doctorDashboard = new DoctorModule('s', "Rodrigo Duterte");
		//secretaryDashboard = new SecretaryModule('s', "Manny Pacquiao");
		//clientDashboard = new SecretaryModule('c', "Leila de Lima");

		login.register.addActionListener(new register_action());
		login.doctor.addActionListener(new login_action());
		login.secretary.addActionListener(new login_action());
		login.client.addActionListener(new login_action());

		mainPane.add(login.getLogInPanel());
		//mainPane.add(doctorDashboard.launchFrame());

		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		
		cf = new ClientFetcher();
		df = new DoctorFetcher();
	}

	class register_action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "Successfully registered!");
		}
	}

	class login_action implements ActionListener
	{
		public  void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(login.doctor))
			{
				//mainFrame.removeAll();
				// Check the existence of the person
				Doctor doctor = df.ifExists(login.lastName.getText() + ", " + login.firstName.getText());
				if (doctor != null) {
					//Doctor exists. Make new doctor module.
					doctorDashboard = new DoctorModule('d', doctor);
					mainFrame.add(doctorDashboard.launchFrame());
					login.getLogInPanel().setVisible(false);
				} else {
					//Doctor does not exist. DO SOMETHING HERE.
				}
			}

			else if(e.getSource().equals(login.secretary))
			{
				//mainFrame.removeAll();
				secretaryDashboard = new SecretaryModule('s', login.firstName.getText().toString() + " " + login.lastName.getText().toString());
				mainFrame.add(secretaryDashboard.launchFrame());
				login.getLogInPanel().setVisible(false);
			}

			else if(e.getSource().equals(login.client))
			{
				//mainFrame.removeAll();
				Client client = cf.ifExists(login.lastName.getText() + ", " + login.firstName.getText());
				if (client != null) {
					//Client exists. Make new client module.
					clientDashboard = new ClientModule('c', client);
					mainFrame.add(clientDashboard.launchFrame());
					login.getLogInPanel().setVisible(false);
				} else {
					//Client does not exist. DO SOMETHING HERE.
				}
			}
		}
	}
	
	private ClientFetcher cf;
	private DoctorFetcher df;
}