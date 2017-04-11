package controller;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import model.Doctor;
import model.DoctorFetcher;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import view.MenuComponent;
import view.SidebarComponent;
import view.CalendarComponent;
import view.AgendaComponent;
import view.ComponentMaker;

public class DoctorModule implements ObserverModule
{
	public DoctorModule(char mode, Doctor doctor)
	{
		this.doctor = doctor;
		green = new Color(24, 200, 148);
		darkGreen = new Color(29, 168, 122);
		lightGreen = new Color(157, 249, 212);
		grey = new Color(157, 174, 169);
		lightGrey = new Color(240, 241, 242);
		white = new Color(255, 255, 255);

		mainFrame = new JPanel(null);
		mainFrame.setBounds(0, 0, 1000, 580);
		mainFrame.setBackground(Color.white);

		menu = new MenuComponent(doctor.getDoctorName(), mode);
		sidebar = new SidebarComponent(mode);
		calendar = new CalendarComponent(mode);
		agenda = new AgendaComponent(mode);

		addMenuActions();
		addSidebarActions();
		addCalendarActions();

		combineAll();

		SidebarComponent sidebarTemp = (SidebarComponent)sidebar;
		CalendarComponent calendarTemp = (CalendarComponent)calendar;
		MenuComponent menuTemp = (MenuComponent)menu;
		sidebarTemp.calendarTable.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
            	int col = sidebarTemp.calendarTable.getSelectedColumn();
	            int row = sidebarTemp.calendarTable.getSelectedRow();
	            
            	if(sidebarTemp.calendarTable.getModel().getValueAt(row, col) != null)
            	{
            		clickedRow = row;
            		clickeColumn = col;
            		String selectedDay = sidebarTemp.calendarTable.getModel().getValueAt(row, col).toString();
            		String[] months =  {"January", "February", "March", "April", "May", "June", "July",
							"August", "September", "October", "November", "December"};

					String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

            		menuTemp.dateLabel.setText(months[sidebarTemp.monthToday].toUpperCase() + " " + selectedDay + ", " +
            			Integer.toString(sidebarTemp.yearToday));

            		calendarTemp.dayField.setText(days[col].toUpperCase());

            		/*
            		Parameter data type: ArrayList<Doctor> doctors, ArrayList<Appointment>, ArrayList<Schedule>, Doctor
            		calendar.updateDetails(doctors, appointment, schedule, person);
            		agenda.updateDetails(doctors, appointment, schedule, person);

            		How to fetch data from ArrayList
            		appointment.get(i).
            		schedule.get(i).
            		*/
	            }
            }
        });
	}

	public void combineAll()
	{
		mainFrame.add(menu.getMainPanel());
		mainFrame.add(sidebar.getMainPanel());
		mainFrame.add(calendar.getMainPanel());
		mainFrame.add(agenda.getMainPanel());
		mainFrame.setVisible(true);
	}

	public void addMenuActions()
	{
		menu.getButton('d').addActionListener(new mode_action());
		menu.getButton('w').addActionListener(new mode_action());
		menu.getButton('c').addActionListener(new form_action());
		menu.getButton('a').addActionListener(new form_action());
	}

	public void addSidebarActions()
	{
		SidebarComponent temp = (SidebarComponent)sidebar;
		sidebar.getButton('c').addActionListener(new create_action());
		temp.free.addActionListener(new filter_action());
		temp.reserved.addActionListener(new filter_action());
	}

	public void addCalendarActions()
	{
		CalendarComponent temp = (CalendarComponent) calendar;

		for(int i = 0; i < temp.sunday.size(); i++)
		{
			temp.sunday.get(i).addActionListener(new cell_action());
			temp.monday.get(i).addActionListener(new cell_action());
			temp.tuesday.get(i).addActionListener(new cell_action());
			temp.wednesday.get(i).addActionListener(new cell_action());
			temp.thursday.get(i).addActionListener(new cell_action());
			temp.friday.get(i).addActionListener(new cell_action());
			temp.saturday.get(i).addActionListener(new cell_action());
			temp.oneDay.get(i).addActionListener(new cell_action());
		}
	}

	public JPanel launchFrame()
	{
		return mainFrame;
	}

	public void updateDetails()
	{
		/* logic for the updates */
		/* to be done by MJ/Mariel */
	}

	/* Action Listener for top menu */
	class mode_action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			CalendarComponent temp = (CalendarComponent)calendar;
			AgendaComponent temp1 = (AgendaComponent) agenda;
			if(e.getSource().equals(menu.getButton('d')))
			{
				menu.getButton('d').setBackground(darkGreen);
				menu.getButton('w').setBackground(green);

				calendar.getPanel('d').setVisible(true);
				calendar.getPanel('w').setVisible(false);

				temp.dailyScrollPane.setVisible(true);
				temp.weeklyScrollPane.setVisible(false);
				temp1.dailyScrollPane.setVisible(true);
				temp1.weeklyScrollPane.setVisible(false);
			}

			else if(e.getSource().equals(menu.getButton('w')))
			{
				menu.getButton('w').setBackground(darkGreen);
				menu.getButton('d').setBackground(green);

				calendar.getPanel('w').setVisible(true);
				calendar.getPanel('d').setVisible(false);

				temp.dailyScrollPane.setVisible(false);
				temp.weeklyScrollPane.setVisible(true);
				temp1.dailyScrollPane.setVisible(false);
				temp1.weeklyScrollPane.setVisible(true);
			}
		}
	}

	class form_action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(menu.getButton('c')))
			{
				menu.getButton('c').setBackground(darkGreen);
				menu.getButton('a').setBackground(green);

				calendar.getMainPanel().setVisible(true);
				agenda.getMainPanel().setVisible(false);
			}

			else if(e.getSource().equals(menu.getButton('a')))
			{
				menu.getButton('a').setBackground(darkGreen);
				menu.getButton('c').setBackground(green);

				calendar.getMainPanel().setVisible(false);
				agenda.getMainPanel().setVisible(true);
			}
		}
	}

	class create_action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String year = sidebar.getInformation('y');
			String month = sidebar.getInformation('m');
			String day = sidebar.getInformation('d');
			String fromTime = sidebar.getInformation('f');
			String toTime = sidebar.getInformation('t');
			String specificDay = "M";

			SidebarComponent sidebarTemp = (SidebarComponent)sidebar;
			sidebarTemp.refreshCalendar(Integer.parseInt(month) - 1, Integer.parseInt(year));
			String[] headers = {"S", "M", "T", "W", "H", "F", "S"};
			for(int i = 0; i < 6; i++)
				for(int j = 0; j < 7; j++)
					if(sidebarTemp.calendarTable.getModel().getValueAt(i, j) != null &&
						sidebarTemp.calendarTable.getModel().getValueAt(i, j).toString().compareTo(day) == 0)
						specificDay = headers[j];


			/*
				Insert these things into the database.
				Then return new things
			*/
		}
	}

	class cell_action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

		}
	}

	class filter_action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			SidebarComponent temp = (SidebarComponent)sidebar;

			if(temp.free.isSelected() == true)
			{
				/* free schedules */
				temp.free.setSelectedIcon(new ImageIcon("resources/selectedCheckBox.png"));
			}

			if(temp.reserved.isSelected() == true)
			{
				/* reserved schedules */
				temp.reserved.setSelectedIcon(new ImageIcon("resources/selectedCheckBox.png"));
			}
		}
	}

	private JPanel mainFrame;
	private Doctor doctor;
	private ComponentMaker menu;
	private ComponentMaker sidebar;
	private ComponentMaker agenda;
	private ComponentMaker calendar;

	private int clickedRow = 0;
	private int clickeColumn = 0;
	private Color green;
	private Color darkGreen;
	private Color lightGreen;
	private Color white;
	private Color grey;
	private Color lightGrey;
}