package view;

import java.util.ArrayList;
import java.time.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;

public class CalendarComponent implements ComponentMaker
{
	public CalendarComponent(char mode)
	{
		grey = createColor(157, 174, 169);
		lightGrey = createColor(240, 241, 242);
		white = createColor(255, 255, 255);

		mainFont = createFont(3, 9);
		eventFont = createFont(1, 8);

		border = createBorder(lightGrey, 1);

		setMainPanel();
		setComponentPanels();
		setComponentScrolls();
		setWeeklyHeaders();
		setDailyTimeLabels();
		setWeeklyTimeLabels();
		setWeeklyButtons();
		setDailyButtons();
		setDailyHeader();

		combineAll();
	}

	public void combineAll()
	{
		for(int i = 0; i < dailyTimeTextFields.size(); i++)
		{
			weeklyForm.add(weeklyTimeTextFields.get(i));
			dailyForm.add(dailyTimeTextFields.get(i));
		}

		weeklyLabelPanel.add(weeklyTimeField);
		dailyLabelPanel.add(dailyTimeField);

		dailyLabelPanel.add(dayField);
		for(int i = 0; i < dayFields.size(); i++)
			weeklyLabelPanel.add(dayFields.get(i));

		for(int i = 0; i < oneDay.size(); i++)
			dailyForm.add(oneDay.get(i));

		for(int i = 0; i < sunday.size(); i++)
		{
			weeklyForm.add(sunday.get(i));
			weeklyForm.add(monday.get(i));
			weeklyForm.add(tuesday.get(i));
			weeklyForm.add(wednesday.get(i));
			weeklyForm.add(thursday.get(i));
			weeklyForm.add(friday.get(i));
			weeklyForm.add(saturday.get(i));
		}

		mainPanel.add(dailyLabelPanel);
		mainPanel.add(weeklyLabelPanel);
		mainPanel.add(dailyScrollPane);
		mainPanel.add(weeklyScrollPane);
	}

	public void setMainPanel()
	{
		mainPanel = createPanel();
		mainPanel.setBounds(225, 53, 775, 525);
		mainPanel.setBackground(white);
		mainPanel.setVisible(true);
	}

	public void setComponentPanels()
	{
		dailyForm = createPanel();
		dailyForm.setBounds(0, 0, 775, 525);
		dailyForm.setBackground(white);
		dailyForm.setVisible(true);
		dailyForm.setPreferredSize(new Dimension(1000, 1000));

		weeklyForm = createPanel();
		weeklyForm.setBounds(0, 0, 775, 525);
		weeklyForm.setBackground(white);
		weeklyForm.setVisible(true);
		weeklyForm.setPreferredSize(new Dimension(1000, 1000));

		weeklyLabelPanel = createPanel();
		weeklyLabelPanel.setBounds(0, 0, 775, 59);
		weeklyLabelPanel.setBackground(white);
		weeklyLabelPanel.setVisible(true);

		dailyLabelPanel = createPanel();
		dailyLabelPanel.setBounds(0, 0, 775, 59);
		dailyLabelPanel.setBackground(white);
		dailyLabelPanel.setVisible(false);
	}

	public void setComponentScrolls()
	{
		dailyScrollPane = createScrollPane('d');
		dailyScrollPane.setBounds(-1, 40, 793, 467);
		dailyScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	dailyScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	dailyScrollPane.getVerticalScrollBar().setUnitIncrement(10);
		dailyScrollPane.setVisible(false);

		weeklyScrollPane = createScrollPane('w');
		weeklyScrollPane.setBounds(-1, 40, 793, 467);
		weeklyScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	weeklyScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	weeklyScrollPane.getVerticalScrollBar().setUnitIncrement(10);
		weeklyScrollPane.setVisible(true);
	}

	public void setDailyTimeLabels()
	{
		dailyTimeField = createField("TIME");
		dailyTimeField.setBounds(-1, 0, 63, 41);
		dailyTimeField.setFont(mainFont);
		dailyTimeField.setBorder(border);
		dailyTimeField.setForeground(grey);
		dailyTimeField.setBackground(white);
		dailyTimeField.setEditable(false);
		dailyTimeField.setHorizontalAlignment(JTextField.CENTER);

		dailyTimeTextFields = createFieldList();
		int offset = -1;

		for(int i = 0; i < 24; i++)
		{
			if(i == 0)
			{
				JTextField first = createField(Integer.toString(i) + ":01");
				JTextField second = createField(Integer.toString(i) + ":30");
				JTextField third = createField(Integer.toString(i) + ":31");

				first.setBounds(-1, offset, 62, 29);
				first.setBorder(border);
				first.setBackground(white);
				first.setForeground(grey);
				first.setFont(mainFont);
				first.setEditable(false);
				first.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				second.setBounds(-1, offset, 62, 29);
				second.setBorder(border);
				second.setBackground(white);
				second.setForeground(grey);
				second.setFont(mainFont);
				second.setEditable(false);
				second.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				third.setBounds(-1, offset, 62, 29);
				third.setBorder(border);
				third.setBackground(white);
				third.setForeground(grey);
				third.setFont(mainFont);
				third.setEditable(false);
				third.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				dailyTimeTextFields.add(first);
				dailyTimeTextFields.add(second);
				dailyTimeTextFields.add(third);
			}

			else
			{
				JTextField first = createField(Integer.toString(i) + ":00");
				JTextField second = createField(Integer.toString(i) + ":01");
				JTextField third = createField(Integer.toString(i) + ":30");
				JTextField fourth = createField(Integer.toString(i) + ":31");

				first.setBounds(-1, offset, 62, 29);
				first.setBorder(border);
				first.setBackground(white);
				first.setForeground(grey);
				first.setFont(mainFont);
				first.setEditable(false);
				first.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				second.setBounds(-1, offset, 62, 29);
				second.setBorder(border);
				second.setBackground(white);
				second.setForeground(grey);
				second.setFont(mainFont);
				second.setEditable(false);
				second.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				third.setBounds(-1, offset, 62, 29);
				third.setBorder(border);
				third.setBackground(white);
				third.setForeground(grey);
				third.setFont(mainFont);
				third.setEditable(false);
				third.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				fourth.setBounds(-1, offset, 62, 29);
				fourth.setBorder(border);
				fourth.setBackground(white);
				fourth.setForeground(grey);
				fourth.setFont(mainFont);
				fourth.setEditable(false);
				fourth.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				dailyTimeTextFields.add(first);
				dailyTimeTextFields.add(second);
				dailyTimeTextFields.add(third);
				dailyTimeTextFields.add(fourth);
			}
		}

		dailyForm.setPreferredSize(new Dimension(1000, offset));
	}

	public void setWeeklyTimeLabels()
	{
		weeklyTimeTextFields = createFieldList();
		int offset = -1;

		for(int i = 0; i < 24; i++)
		{
			if(i == 0)
			{
				JTextField first = createField(Integer.toString(i) + ":01");
				JTextField second = createField(Integer.toString(i) + ":30");
				JTextField third = createField(Integer.toString(i) + ":31");

				first.setBounds(-1, offset, 62, 29);
				first.setBorder(border);
				first.setBackground(white);
				first.setForeground(grey);
				first.setFont(mainFont);
				first.setEditable(false);
				first.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				second.setBounds(-1, offset, 62, 29);
				second.setBorder(border);
				second.setBackground(white);
				second.setForeground(grey);
				second.setFont(mainFont);
				second.setEditable(false);
				second.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				third.setBounds(-1, offset, 62, 29);
				third.setBorder(border);
				third.setBackground(white);
				third.setForeground(grey);
				third.setFont(mainFont);
				third.setEditable(false);
				third.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				weeklyTimeTextFields.add(first);
				weeklyTimeTextFields.add(second);
				weeklyTimeTextFields.add(third);
			}

			else
			{
				JTextField first = createField(Integer.toString(i) + ":00");
				JTextField second = createField(Integer.toString(i) + ":01");
				JTextField third = createField(Integer.toString(i) + ":30");
				JTextField fourth = createField(Integer.toString(i) + ":31");

				first.setBounds(-1, offset, 62, 29);
				first.setBorder(border);
				first.setBackground(white);
				first.setForeground(grey);
				first.setFont(mainFont);
				first.setEditable(false);
				first.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				second.setBounds(-1, offset, 62, 29);
				second.setBorder(border);
				second.setBackground(white);
				second.setForeground(grey);
				second.setFont(mainFont);
				second.setEditable(false);
				second.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				third.setBounds(-1, offset, 62, 29);
				third.setBorder(border);
				third.setBackground(white);
				third.setForeground(grey);
				third.setFont(mainFont);
				third.setEditable(false);
				third.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				fourth.setBounds(-1, offset, 62, 29);
				fourth.setBorder(border);
				fourth.setBackground(white);
				fourth.setForeground(grey);
				fourth.setFont(mainFont);
				fourth.setEditable(false);
				fourth.setHorizontalAlignment(JTextField.CENTER);

				offset += 28;

				weeklyTimeTextFields.add(first);
				weeklyTimeTextFields.add(second);
				weeklyTimeTextFields.add(third);
				weeklyTimeTextFields.add(fourth);
			}
		}

		weeklyForm.setPreferredSize(new Dimension(1000, offset));
	}

	public void setWeeklyHeaders()
	{
		weeklyTimeField = createField("TIME");
		weeklyTimeField.setBounds(-1, 0, 63, 41);
		weeklyTimeField.setFont(mainFont);
		weeklyTimeField.setBorder(border);
		weeklyTimeField.setForeground(grey);
		weeklyTimeField.setBackground(white);
		weeklyTimeField.setEditable(false);
		weeklyTimeField.setHorizontalAlignment(JTextField.CENTER);

		String[] headers = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
		dayFields = createFieldList();
		int offset = 0;
		int width = 104;
		int height = 41;

		for(int i = 0; i < headers.length; i++)
		{
			JTextField temp = createField(headers[i]);
			temp.setBounds(60 + offset, 0, width, height);
			temp.setFont(mainFont);
			temp.setForeground(grey);
			temp.setBackground(white);
			temp.setEditable(false);
			temp.setBorder(border);
			temp.setHorizontalAlignment(JTextField.CENTER);

			dayFields.add(temp);
			offset += 102;
		}
	}

	public void setWeeklyButtons()
	{
		sunday = createButtonList();
		monday = createButtonList();
		tuesday = createButtonList();
		wednesday = createButtonList();
		thursday = createButtonList();
		friday = createButtonList();
		saturday = createButtonList();

		int yOffset = -1;
		int width = 103;
		int height = 29;

		for(int i = 0; i < weeklyTimeTextFields.size(); i++)
		{
			int xOffset = 0;

			JButton temp1 = createButton(""); 
			temp1.setFont(eventFont);
			temp1.setForeground(grey);
			temp1.setBackground(white);
			temp1.setBorder(border);

			temp1.setBounds(60 + xOffset, yOffset, width, height);
			sunday.add(temp1);
			xOffset += 102;

			JButton temp2 = createButton(""); 
			temp2.setFont(eventFont);
			temp2.setForeground(grey);
			temp2.setBackground(white);
			temp2.setBorder(border);

			temp2.setBounds(60 + xOffset, yOffset, width, height);
			monday.add(temp2);
			xOffset += 102;

			JButton temp3 = createButton(""); 
			temp3.setFont(eventFont);
			temp3.setForeground(grey);
			temp3.setBackground(white);
			temp3.setBorder(border);

			temp3.setBounds(60 + xOffset, yOffset, width, height);
			tuesday.add(temp3);
			xOffset += 102;

			JButton temp4 = createButton(""); 
			temp4.setFont(eventFont);
			temp4.setForeground(grey);
			temp4.setBackground(white);
			temp4.setBorder(border);

			temp4.setBounds(60 + xOffset, yOffset, width, height);
			wednesday.add(temp4);
			xOffset += 102;

			JButton temp5 = createButton(""); 
			temp5.setFont(eventFont);
			temp5.setForeground(grey);
			temp5.setBackground(white);
			temp5.setBorder(border);

			temp5.setBounds(60 + xOffset, yOffset, width, height);
			thursday.add(temp5);
			xOffset += 102;

			JButton temp6 = createButton(""); 
			temp6.setFont(eventFont);
			temp6.setForeground(grey);
			temp6.setBackground(white);
			temp6.setBorder(border);

			temp6.setBounds(60 + xOffset, yOffset, width, height);
			friday.add(temp6);
			xOffset += 102;

			JButton temp7 = createButton(""); 
			temp7.setFont(eventFont);
			temp7.setForeground(grey);
			temp7.setBackground(white);
			temp7.setBorder(border);

			temp7.setBounds(60 + xOffset, yOffset, width, height);
			saturday.add(temp7);
			xOffset += 102;

			yOffset += 28;
		}
	}

	public void setDailyButtons()
	{
		oneDay = createButtonList();
		int yOffset = -1;
		int width = 721;
		int height = 29;

		for(int i = 0; i < dailyTimeTextFields.size(); i++)
		{
			JButton temp = createButton("");
			temp.setBounds(60, yOffset, width, height);
			temp.setBorder(border);
			temp.setForeground(grey);
			temp.setBackground(white);
			oneDay.add(temp);

			yOffset += 28;
		}
	}

	public void setDailyHeader()
	{
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		String dayNow = "MONDAY";
		switch(dayOfWeek.getValue())
		{
			case 1: dayNow = "MONDAY";
			break;

			case 2: dayNow = "TUESDAY";
			break;

			case 3: dayNow = "WEDNESDAY";
			break;

			case 4: dayNow = "THURSDAY";
			break;

			case 5: dayNow = "FRIDAY";
			break;

			case 6: dayNow = "SATURDAY";
			break;

			case 7: dayNow = "SUNDAY";
			break;
		}

		dayField = createField(dayNow);
		dayField.setBounds(60, 0, 716, 41);
		dayField.setFont(mainFont);
		dayField.setBorder(border);
		dayField.setBackground(white);
		dayField.setForeground(grey);
		dayField.setEditable(false);
		dayField.setHorizontalAlignment(JTextField.CENTER);
	}

	public JPanel getPanel(char command)
	{
		if(command == 'w')
			return weeklyLabelPanel;

		return dailyLabelPanel;
	}

	public JPanel getMainPanel()
	{
		return mainPanel;
	}

	public JScrollPane getScrollPane(char command)
	{
		if(command == 'w')
			return weeklyScrollPane;

		return dailyScrollPane;
	}

	public String getInformation(char command)
	{
		return "Hello";	
	}

	public JButton getButton(char command)
	{
		return new JButton();
	}

	public void updateDetails()
	{

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

	public JScrollPane createScrollPane(char command)
	{
		if(command == 'd')
			return new JScrollPane(dailyForm);

		return new JScrollPane(weeklyForm);
	}

	public ArrayList<JTextField> createFieldList()
	{
		return new ArrayList<JTextField>();
	}

	public ArrayList<JButton> createButtonList()
	{
		return new ArrayList<JButton>();
	}

	public JPanel mainPanel;

	public JScrollPane dailyScrollPane;
	public JScrollPane weeklyScrollPane;

	public JPanel dailyForm;
	public JPanel weeklyForm;
	public JPanel weeklyLabelPanel;
	public JPanel dailyLabelPanel;

	public JTextField dailyTimeField;
	public JTextField weeklyTimeField;
	public JTextField dayField;
	public ArrayList<JTextField> dailyTimeTextFields;
	public ArrayList<JTextField> weeklyTimeTextFields;
	public ArrayList<JTextField> dayFields;

	public ArrayList<JButton> sunday;
	public ArrayList<JButton> monday;
	public ArrayList<JButton> tuesday;
	public ArrayList<JButton> wednesday;
	public ArrayList<JButton> thursday;
	public ArrayList<JButton> friday;
	public ArrayList<JButton> saturday;
	public ArrayList<JButton> oneDay;

	private Font mainFont;
	private Font eventFont;
	private LineBorder border;

	private Color white;
	private Color grey;
	private Color lightGrey;
	private Color freeColor;
	private Color reservedColor;
}