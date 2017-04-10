package view;

import java.util.*;
import java.time.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MenuComponent implements ComponentMaker
{
	public MenuComponent(String name, char mode)
	{
		green = createColor(24, 200, 148);
		darkGreen = createColor(29, 168, 122);
		lightGreen = createColor(157, 249, 212);
		white = createColor(255, 255, 255);

		darkGreenBorder = createBorder(darkGreen, 1);
		mainFont = createFont(3, 11);

		setMainPanel();
		setButtons();
		setLabels(name);
		combineAll();

		if(mode == 's')
			transformSecretary(name);

		else if(mode == 'c')
			transformClient(name);
	}

	public void combineAll()
	{
		userPanel.add(nameLabel);
		mainPanel.add(notificationsButton);
		mainPanel.add(userPanel);
		mainPanel.add(dateLabel);
		mainPanel.add(dailyButton);
		mainPanel.add(weeklyButton);
		mainPanel.add(calendarButton);
		mainPanel.add(agendaButton);
	}

	public void transformSecretary(String name)
	{
		nameLabel.setText("Sec. " + name);
	}

	public void transformClient(String name)
	{
		nameLabel.setText("Mr/Ms. " + name);
	}

	public void setMainPanel()
	{
		mainPanel = createPanel();
		mainPanel.setBounds(-1, -1, 1002, 54);
		mainPanel.setBackground(green);
		mainPanel.setBorder(darkGreenBorder);

		userPanel = createPanel();
		userPanel.setBounds(796, 0, 205, 54);
		userPanel.setBackground(darkGreen);
		userPanel.setBorder(darkGreenBorder);
	}

	public void setButtons()
	{
		notificationsButton = createButton("");
		notificationsButton.setIcon(new ImageIcon("resources/notifications-inactive.png"));
		notificationsButton.setBounds(40, 11, 30, 30);
		notificationsButton.setBackground(green);
		notificationsButton.setBorder(null);
		notificationsButton.addActionListener(new notif_action());

		dailyButton = createButton("Daily");
		dailyButton.setBounds(77, 11, 90, 31);
		dailyButton.setFont(mainFont);
		dailyButton.setForeground(white);
		dailyButton.setBackground(green);
		dailyButton.setBorderPainted(false);
		dailyButton.setOpaque(true);

		weeklyButton = createButton("Weekly");
		weeklyButton.setBounds(167, 11, 90, 31);
		weeklyButton.setFont(mainFont);
		weeklyButton.setForeground(white);
		weeklyButton.setBackground(darkGreen);
		weeklyButton.setBorderPainted(false);
		weeklyButton.setOpaque(true);

		calendarButton = createButton("Calendar");
		calendarButton.setBounds(552, 11, 97, 31);
		calendarButton.setFont(mainFont);
		calendarButton.setForeground(white);
		calendarButton.setBackground(darkGreen);
		calendarButton.setBorderPainted(false);
		calendarButton.setOpaque(true);

		agendaButton = createButton("Agenda");
		agendaButton.setBounds(659, 11, 97, 31);
		agendaButton.setFont(mainFont);
		agendaButton.setForeground(white);
		agendaButton.setBackground(green);
		agendaButton.setBorderPainted(false);
		agendaButton.setOpaque(true);
	}

	public void setLabels(String name)
	{
		nameLabel = createLabel("Dr. " + name);
		nameLabel.setBounds(30, 10, 200, 30);
		nameLabel.setFont(mainFont);
		nameLabel.setForeground(lightGreen);

		LocalDate localdate = LocalDate.now();
		month = localdate.getMonth().toString();
		day = localdate.getDayOfMonth();
		year = localdate.getYear();

		dateLabel = createLabel(month + " " + Integer.toString(day) + ", " + Integer.toString(year));
		dateLabel.setBounds(363, 11, 90, 31);
		dateLabel.setBounds(355, 11, 150, 31);
		dateLabel.setFont(mainFont);
		dateLabel.setForeground(white);
	}

	public JPanel getMainPanel()
	{
		return mainPanel;
	}

	public String getInformation(char command)
	{
		if(command == 'd')
			return dateLabel.getText().toString();

		return nameLabel.getText().toString();
	}

	public JButton getButton(char command)
	{
		switch(command)
		{
			case 'd': return dailyButton;
			case 'w': return weeklyButton;
			case 'c': return calendarButton;
		}

		return agendaButton;
	}

	public void updateDetails()
	{

	}

	public JPanel getPanel(char command)
	{
		return userPanel;
	}

	public JPanel createPanel()
	{
		return new JPanel(null);
	}

	public JButton createButton(String content)
	{
		return new JButton(content);
	}

	public JTextField createField(String content)
	{
		return new JTextField(content);
	}

	public Color createColor(int red, int green, int blue)
	{
		return new Color(red, green, blue);
	}

	public LineBorder createBorder(Color color, int thickness)
	{
		return new LineBorder(color, thickness);
	}

	public Font createFont(int style, int points)
	{
		if(style == 1)
			return new Font("Avenir Next", Font.PLAIN, points);

		else if(style == 2)
			return new Font("Avenir Next", Font.ITALIC, points);

		return new Font("Avenir Next", Font.BOLD, points);
	}

	public JCheckBox createCheckBox(String content)
	{
		return new JCheckBox(content);
	}

	public JRadioButton createRadio(String content)
	{
		return new JRadioButton(content);
	}

	public JComboBox createComboBox()
	{
		return new JComboBox();
	}

	public JLabel createLabel(String content)
	{
		return new JLabel(content);
	}

	private JPanel mainPanel;
	private JPanel userPanel;

	private JButton notificationsButton;
	private JButton dailyButton;
	private JButton weeklyButton;
	private JButton notificationButton;
	private JButton calendarButton;
	private JButton agendaButton;

	public JLabel dateLabel;
	private JLabel nameLabel;

	private String month;
	private int day;
	private int year;

	private LineBorder darkGreenBorder;
	private Font mainFont;

	private Color green;
	private Color darkGreen;
	private Color lightGreen;
	private Color white;
}