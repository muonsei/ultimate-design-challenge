import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class SecretaryModule implements ObserverModule
{
	public SecretaryModule(char mode, String name)
	{
		this.name = name;
		green = new Color(24, 200, 148);
		darkGreen = new Color(29, 168, 122);
		lightGreen = new Color(157, 249, 212);
		grey = new Color(157, 174, 169);
		lightGrey = new Color(240, 241, 242);
		white = new Color(255, 255, 255);

		mainFrame = new JPanel(null);
		mainFrame.setBounds(0, 0, 1000, 580);
		mainFrame.setBackground(Color.white);

		menu = new MenuComponent(this.name);
		sidebar = new SidebarComponent(mode);
		calendar = new CalendarComponent(mode);
		agenda = new AgendaComponent(mode);

		addMenuActions();
		//addSidebarActions();
		//addCalendarActions();

		combineAll();
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

	public JPanel launchFrame()
	{
		return mainFrame;
	}

	public void updateDetails()
	{
		/* logic for the updates */
	}

	class mode_action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			CalendarComponent temp = (CalendarComponent)calendar;
			if(e.getSource().equals(menu.getButton('d')))
			{
				menu.getButton('d').setBackground(darkGreen);
				menu.getButton('w').setBackground(green);
				calendar.getPanel('d').setVisible(true);
				calendar.getPanel('w').setVisible(false);
				temp.dailyScrollPane.setVisible(true);
				temp.weeklyScrollPane.setVisible(false);
			}

			else if(e.getSource().equals(menu.getButton('w')))
			{
				menu.getButton('w').setBackground(darkGreen);
				menu.getButton('d').setBackground(green);
				calendar.getPanel('w').setVisible(true);
				calendar.getPanel('d').setVisible(false);
				temp.dailyScrollPane.setVisible(false);
				temp.weeklyScrollPane.setVisible(true);
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
			}

			else if(e.getSource().equals(menu.getButton('a')))
			{
				menu.getButton('a').setBackground(darkGreen);
				menu.getButton('c').setBackground(green);
			}
		}
	}

	private JPanel mainFrame;
	private String name;
	private ComponentMaker menu;
	private ComponentMaker sidebar;
	private ComponentMaker agenda;
	private ComponentMaker calendar;

	private Color green;
	private Color darkGreen;
	private Color lightGreen;
	private Color white;
	private Color grey;
	private Color lightGrey;
}