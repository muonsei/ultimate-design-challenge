import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;

public class SidebarComponent implements ComponentMaker
{
	public SidebarComponent(char mode)
	{
		green = createColor(24, 200, 148);
		darkGreen = createColor(29, 168, 122);
		lightGreen = createColor(157, 249, 212);
		grey = createColor(157, 174, 169);
		lightGrey = createColor(240, 241, 242);
		white = createColor(255, 255, 255);

		greyBorder = createBorder(grey, 1);
		lightGreyBorder = createBorder(lightGrey, 1);

		mainFont = createFont(4, 13);
		italicMainFont = createFont(2, 13);
		subFont = createFont(1, 10);
		italicSubFont = createFont(2, 10);
		filterFont = createFont(3, 13);

		setMainPanel();
		setButtons();
		setCheckBox();
		setComboBox();
		setFields();
		setLabels();
		setFilterSet();
		setBehalf();
		setTimeLabels();
		setCalendarComponents();
		refreshCalendar(monthToday, yearToday);

		combineCalendarComponents();
		combineAll();

		addCalendarActions();

		if(mode == 's')
			transformSecretary();

		else if(mode == 'c')
			transformClient();
	}

	public void transformSecretary()
	{
		eventField.setBounds(10, 220, 205, 30);
		yearField.setBounds(10, 258, 75, 25);
		monthField.setBounds(90, 258, 60, 25);
		dayField.setBounds(155, 258, 60, 25);
		from.setBounds(10, 290, 205, 25);
		to.setBounds(10, 320, 205, 25);
		createButton.setBounds(10, 350, 205, 40);

		free.setVisible(false);
		reserved.setVisible(false);
		filter.setVisible(false);

		mainPanel.add(filterSet);
		mainPanel.add(onBehalf);
	}

	public void transformClient()
	{
		eventField.setBounds(10, 190, 205, 30);
		yearField.setBounds(10, 228, 75, 25);
		monthField.setBounds(90, 228, 60, 25);
		dayField.setBounds(155, 228, 60, 25);
		createButton.setBounds(10, 330, 205, 40);

		createButton.setText("Reserve");

		free.setVisible(false);
		reserved.setVisible(false);
		filter.setVisible(false);
		from.setVisible(false);
		to.setVisible(false);

		eventField.setEditable(false);
		yearField.setEditable(false);
		monthField.setEditable(false);
		dayField.setEditable(false);

		mainPanel.add(fromLabel);
		mainPanel.add(toLabel);

	}

	public void combineAll()
	{
		mainPanel.add(createButton);
		mainPanel.add(free);
		mainPanel.add(reserved);
		mainPanel.add(to);
		mainPanel.add(from);
		mainPanel.add(eventField);
		mainPanel.add(yearField);
		mainPanel.add(monthField);
		mainPanel.add(dayField);
		mainPanel.add(filter);
	}

	public void combineCalendarComponents()
	{
		mainPanel.add(monthLabel);
		mainPanel.add(dateLabel);
		mainPanel.add(next);
		mainPanel.add(previous);
		mainPanel.add(scrollCalendarTable);
	}

	public void setFields()
	{
		eventField = createField("Schedule Name");
		yearField = createField("YYYY");
		monthField = createField("MM");
		dayField = createField("DD");

		eventField.setBounds(10, 190, 205, 30);
		eventField.setBackground(white);
		eventField.setForeground(grey);
		eventField.setVisible(true);
		eventField.setFont(italicMainFont);
		eventField.setHorizontalAlignment(SwingConstants.CENTER);
		eventField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		yearField.setBounds(10, 228, 75, 25);
		yearField.setBackground(white);
		yearField.setForeground(grey);
		yearField.setVisible(true);
		yearField.setFont(subFont);
		yearField.setHorizontalAlignment(SwingConstants.CENTER);
		yearField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		monthField.setBounds(90, 228, 60, 25);
		monthField.setBackground(white);
		monthField.setForeground(grey);
		monthField.setVisible(true);
		monthField.setFont(subFont);
		monthField.setHorizontalAlignment(SwingConstants.CENTER);
		monthField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		dayField.setBounds(155, 228, 60, 25);
		dayField.setBackground(white);
		dayField.setForeground(grey);
		dayField.setVisible(true);
		dayField.setFont(subFont);
		dayField.setHorizontalAlignment(SwingConstants.CENTER);
		dayField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

	}

	public void setLabels()
	{
		filter = createLabel("Filter");
		filter.setBounds(20, 400, 70, 30);
		filter.setBackground(lightGrey);
		filter.setForeground(grey);
		filter.setVisible(true);
		filter.setFont(filterFont);
	}

	public void setButtons()
	{
		createButton = createButton("Create");
		createButton.setBounds(10, 330, 205, 40);
		createButton.setBackground(green);
		createButton.setForeground(white);
		createButton.setFont(mainFont);
		createButton.setOpaque(true);
		createButton.setBorderPainted(false);
	}

	public void setCheckBox()
	{
		free = createCheckBox("Free");
		reserved = createCheckBox("Reserved");

		free.setBounds(20, 430, 50, 20);
		free.setBackground(lightGrey);
		free.setForeground(grey);
		free.setVisible(true);
		free.setFont(subFont);
		free.setSelectedIcon(new ImageIcon("images/checkBox.png"));
		free.setOpaque(true);
	
		reserved.setBounds(90, 430, 70, 20);
		reserved.setBackground(lightGrey);
		reserved.setForeground(grey);
		reserved.setVisible(true);
		reserved.setFont(subFont);
		reserved.setSelectedIcon(new ImageIcon("images/checkBox.png"));
		reserved.setOpaque(true);
	}

	public void setComboBox()
	{
		from = createComboBox();
		to = createComboBox();

		from.setBounds(10, 260, 205, 25);
		from.setBackground(white);
		from.setVisible(true);
		from.setEditable(true);
		from.setForeground(grey);
		from.setSelectedItem("From what time?");
		from.setEditable(false);
		from.setOpaque(true);
		from.setFont(italicSubFont);

		for(int i = 0; i < 24; i++)
		{
			from.addItem(String.valueOf(i) + ":01");
			from.addItem(String.valueOf(i) + ":31");
		}

		to.setBounds(10, 290, 205, 25);
		to.setBackground(white);
		to.setVisible(true);
		to.setEditable(true);
		to.setForeground(grey);
		to.setSelectedItem("To what time?");
		to.setEditable(false);
		to.setOpaque(true);
		to.setFont(italicSubFont);

		for(int i = 0; i < 24; i++)
		{
			to.addItem(String.valueOf(i) + ":00");
			to.addItem(String.valueOf(i) + ":30");
		}
	}

	public void setTimeLabels()
	{
		fromLabel = createField("fromSched");
		toLabel = createField("toSched");

		fromLabel.setBounds(10, 260, 205, 25);
		fromLabel.setBackground(white);
		fromLabel.setVisible(true);
		fromLabel.setEditable(false);
		fromLabel.setForeground(grey);
		fromLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fromLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		toLabel.setBounds(10, 290, 205, 25);
		toLabel.setBackground(white);
		toLabel.setVisible(true);
		toLabel.setEditable(false);
		toLabel.setForeground(grey);
		toLabel.setHorizontalAlignment(SwingConstants.CENTER);
		toLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	}

	public void setBehalf()
	{
		onBehalf = createComboBox();
		onBehalf.setBounds(10, 180, 205, 25);
		onBehalf.setBackground(grey);
		onBehalf.setVisible(true);
		onBehalf.setEditable(true);
		onBehalf.setForeground(white);
		onBehalf.setSelectedItem("On behalf of...");
		onBehalf.setOpaque(true);
		onBehalf.setEditable(false);
		onBehalf.setFont(italicSubFont);

	}

	public void setFilterSet()
	{
		filterSet = createButton("Filter Setting");
		filterSet.setBounds(10, 400, 205, 25);
		filterSet.setBackground(lightGrey);
		filterSet.setForeground(grey);
		filterSet.setFont(subFont);
		filterSet.setOpaque(true);
		filterSet.setBorderPainted(false);
	}

	public void setMainPanel()
	{
		mainPanel = createPanel();
		mainPanel.setBounds(0, 53, 225, 525);
		mainPanel.setBackground(lightGrey);
		mainPanel.setBorder(lightGreyBorder);
	}

	public JPanel getMainPanel()
	{
		return mainPanel;
	}

	public String getInformation(char command)
	{
		switch(command)
		{
			case 'e': return eventField.getText().toString();
			case 'y': return yearField.getText().toString();
			case 'm': return monthField.getText().toString();
			case 'd': return dayField.getText().toString();
			case 'f': return from.getSelectedItem().toString();
		}

		return to.getSelectedItem().toString();
	}

	public JPanel getPanel(char command)
	{
		return mainPanel;
	}

	public JButton getButton(char command)
	{
		return createButton;
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

		else if(style == 3)
			return new Font("Avenir Next", Font.PLAIN, points);

		return new Font("Avenir Next", Font.BOLD, points);
	}

	public JCheckBox createCheckBox(String content)
	{
		return new JCheckBox(content, new ImageIcon("images/checkBox.png"));
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

	public void setCalendarComponents()
	{
		monthLabel = new JLabel("January");
		next = new JButton(">");
		previous = new JButton("<");

		modelCalendarTable = new DefaultTableModel()
        {
            public boolean isCellEditable(int rowIndex, int mColIndex)
            {
                return false;
            }
        };

		calendarTable = new JTable(modelCalendarTable);
        scrollCalendarTable = new JScrollPane(calendarTable);

		previous.setBounds(30, 10, 20, 20);
		next.setBounds(173, 10, 20, 20);
		scrollCalendarTable.setBounds(10, 40, 205, 140);

		GregorianCalendar cal = new GregorianCalendar();
		dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
		monthBound = cal.get(GregorianCalendar.MONTH);
		yearBound = cal.get(GregorianCalendar.YEAR);
		monthToday = monthBound; 
		yearToday = yearBound;

		dateLabel = new JLabel(monthLabel.getText().toString() + " " + Integer.toString(yearBound));
		dateLabel.setBounds(0, -5, 225, 50);
		dateLabel.setFont(mainFont);
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(grey);
		
		String[] headers = {"  S", "  M", "  T", "  W", "  T", "  F", "  S"}; //All headers
		for (int i=0; i<7; i++){
			modelCalendarTable.addColumn(headers[i]);
		}
		
		calendarTable.getParent().setBackground(calendarTable.getBackground()); //Set background

		calendarTable.getTableHeader().setResizingAllowed(false);
		calendarTable.getTableHeader().setReorderingAllowed(false);

		calendarTable.setColumnSelectionAllowed(true);
		calendarTable.setRowSelectionAllowed(true);
		calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		calendarTable.setRowHeight(20);
		modelCalendarTable.setColumnCount(7);
		modelCalendarTable.setRowCount(6);

		calendarTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		calendarTable.getColumnModel().getColumn(0).setPreferredWidth(29);
		calendarTable.getColumnModel().getColumn(1).setPreferredWidth(29);
		calendarTable.getColumnModel().getColumn(2).setPreferredWidth(29);
		calendarTable.getColumnModel().getColumn(3).setPreferredWidth(29);
		calendarTable.getColumnModel().getColumn(4).setPreferredWidth(29);
		calendarTable.getColumnModel().getColumn(5).setPreferredWidth(28);
		calendarTable.getColumnModel().getColumn(6).setPreferredWidth(28);

		scrollCalendarTable.setBorder(null);
	}

	public void refreshCalendar(int month, int year)
	{
		String[] months =  {"January", "February", "March", "April", "May", "June", "July",
							"August", "September", "October", "November", "December"};
		int nod, som, i, j;
		
		previous.setEnabled(true);
		next.setEnabled(true);
		if (month == 0 && year <= yearBound-10)
	        previous.setEnabled(false);
		if (month == 11 && year >= yearBound+100)
	        next.setEnabled(false);
	            
		//monthLabel.setText(months[month]);
		dateLabel.setText(months[month] + " " + String.valueOf(year));
		
		for (i = 0; i < 6; i++)
			for (j = 0; j < 7; j++)
				modelCalendarTable.setValueAt(null, i, j);
		
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);
		
		for (i = 1; i <= nod; i++)
	    {
			int row = new Integer((i+som-2)/7);
			int column  =  (i+som-2)%7;

			modelCalendarTable.setValueAt(i, row, column);
		}

		calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new TableRenderer());
	}

	class btnPrev_action implements ActionListener
    {
		public void actionPerformed(ActionEvent e)
        {
			if (monthToday == 0)
			{
				monthToday = 11;
				yearToday -= 1;
            }

			else monthToday -= 1;

			refreshCalendar(monthToday, yearToday);
		}
	}

	class btnNext_action implements ActionListener
   	{
		public void actionPerformed(ActionEvent e)
        {
			if (monthToday == 11)
			{
				monthToday = 0;
				yearToday += 1;
			}

			else monthToday += 1;

			refreshCalendar(monthToday, yearToday);
		}
	}

	public void addCalendarActions()
	{
		next.addActionListener(new btnNext_action());
		previous.addActionListener(new btnPrev_action());
	}

	public void updateDetails()
	{

	}

	public JPanel mainPanel;

	public JButton createButton;
	public JButton filterSet;

	public JCheckBox free;
	public JCheckBox reserved;

	public JComboBox from;
	public JComboBox to;
	public JComboBox onBehalf;

	public JLabel filter;
	public JTextField fromLabel;
	public JTextField toLabel;
	
	public JTextField eventField;
	public JTextField yearField;
	public JTextField monthField;
	public JTextField dayField;

	private LineBorder lightGreyBorder;
	private LineBorder greyBorder;

	private Font mainFont;
	private Font italicMainFont;
	private Font subFont;
	private Font italicSubFont;
	private Font filterFont;

	private Color green;
	private Color darkGreen;
	private Color lightGreen;
	private Color white;
	private Color grey;
	private Color lightGrey;


	/* For the calendar components */
	private JLabel monthLabel;
	private JLabel dateLabel;

	private JButton next;
	private JButton previous;

	private JScrollPane scrollCalendarTable;
	private DefaultTableModel modelCalendarTable;
	private JTable calendarTable;

	private int dayBound;
	private int monthBound;
	private int yearBound;
	private int monthToday;
	private int yearToday;
}