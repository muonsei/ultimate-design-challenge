package view;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class LoginPage
{
	public LoginPage()
	{
		clinicGreen = new Color(24, 200, 148);
		white = new Color(244, 249, 247);
		darkGreen = new Color(47, 176, 194);
		lightGrey = new Color(222, 226, 224);
		darkBlue = new Color(23, 25, 39);

		font1 = new Font("Montserrat", Font.PLAIN, 18);
		font2 = new Font("Montserrat", Font.BOLD, 17);

		setLogPanel();
		setDButton();
		setSButton();
		setCButton();
		setRButton();
		setFirstName();
		setLastName();
		setLogo();

		combineAll();

	}

	public void combineAll()
	{
		logPanel.add(doctor);
		logPanel.add(secretary);
		logPanel.add(client);
		logPanel.add(firstName);
		logPanel.add(lastName);
		logPanel.add(logo);
		logPanel.add(register);
	}

	public void setLogPanel()
	{
		logPanel = new JPanel(null);
		logPanel.setBounds(0, 0, 1000, 580);
		logPanel.setBackground(darkBlue);
	}

	public void setDButton()
	{
		doctor = new JButton(new ImageIcon("resources/DoctorIcon.png"));
		doctor.setBounds(200, 270, 150, 150);
		doctor.setBackground(darkBlue);
		//doctor.setFont(font2);
		doctor.setVisible(true);
		doctor.setBorderPainted(false);
		doctor.setOpaque(true);
	}

	public void setSButton()
	{
		secretary = new JButton(new ImageIcon("resources/SecretaryIcon.png"));
		secretary.setBounds(420, 270, 150, 150);
		secretary.setBackground(darkBlue);
		//secretary.setFont(font2);
		secretary.setVisible(true);
		secretary.setBorderPainted(false);
		secretary.setOpaque(true);
	}

	public void setCButton()
	{
		client = new JButton(new ImageIcon("resources/ClientIcon.png"));
		client.setBounds(645, 270, 150, 150);
		client.setBackground(darkBlue);
		//client.setFont(font2);
		client.setVisible(true);
		client.setBorderPainted(false);
		client.setOpaque(true);
	}

	public void setRButton()
	{
		register = new JButton("REGISTER");
		register.setBounds(410, 440, 170, 40);
		register.setBackground(clinicGreen);
		register.setFont(font1);
		register.setForeground(white);
		register.setVisible(true);
		register.setOpaque(true);
		register.setBorderPainted(false);
	}

	public void setFirstName()
	{
		firstName = new JTextField("First Name");
		firstName.setBounds(210, 220, 250, 50);
		firstName.setBackground(white);
		firstName.setFont(font1);
		//firstName.setForeground(lightGrey);
		firstName.setVisible(true);
		firstName.setHorizontalAlignment(JTextField.CENTER);

	}

	public void setLastName()
	{
		lastName = new JTextField("Last Name");
		lastName.setBounds(530, 220, 250, 50);
		lastName.setBackground(white);
		lastName.setFont(font1);
		//lastName.setForeground(lightGrey);
		lastName.setVisible(true);
		lastName.setHorizontalAlignment(JTextField.CENTER);
	}

	public void setLogo()
	{
		logo = new JLabel(new ImageIcon("resources/Logo.png"));
		logo.setBounds(200, 60, 600, 200);
		logo.setVisible(true);
	}

	public JButton getDButton()
	{
		return doctor;
	}

	public JButton getSButton()
	{
		return secretary;
	}

	public JButton getCButton()
	{
		return client;
	}

	public JButton getRButton()
	{
		return register;
	}

	public String getFirstName()
	{
		return firstName.getText().toString();
	}

	public String getLastName()
	{
		return lastName.getText().toString();
	}

	public JPanel getLogInPanel()
	{
		return logPanel;
	}

	private JPanel logPanel;

	private JLabel logo;

	public JTextField firstName;
	public JTextField lastName;

	public JButton doctor;
	public JButton secretary;
	public JButton client;
	public JButton register;

	private Font font1;
	private Font font2;

	private Color clinicGreen;
	private Color darkGreen;
	private Color white;
	private Color lightGrey;
	private Color darkBlue;
}