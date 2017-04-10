import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;

public class AgendaComponent implements ComponentMaker
{
	public AgendaComponent(char mode)
	{
		green = createColor(24, 200, 148);
		darkGreen = createColor(29, 168, 122);
		grey = createColor(157, 174, 169);
		lightGrey = createColor(240, 241, 242);
		white = createColor(255, 255, 255);

		headerFont = createFont(3, 17);
		eventFont = createFont(1, 12);

		setMainPanel();
		setComponentPanels();
		setComponentScrolls();

		combineAll();
	}

	public void combineAll()
	{
		mainPanel.add(dailyScrollPane);
		mainPanel.add(weeklyScrollPane);
	}

	public void setMainPanel()
	{
		mainPanel = createPanel();
		mainPanel.setBounds(225, 53, 775, 525);
		mainPanel.setBackground(white);
		mainPanel.setVisible(false);
	}

	public void setComponentPanels()
	{
		dailyForm = createPanel();
		dailyForm.setBounds(-1, -1, 775, 525);
		dailyForm.setBackground(white);
		dailyForm.setVisible(true);
		dailyForm.setBorder(null);
		dailyForm.setPreferredSize(new Dimension(1000, 1000));

		weeklyForm = createPanel();
		weeklyForm.setBounds(-1, -1, 775, 525);
		weeklyForm.setBackground(lightGrey);
		weeklyForm.setVisible(true);
		weeklyForm.setBorder(null);
		weeklyForm.setPreferredSize(new Dimension(1000, 1000));
	}

	public void setComponentScrolls()
	{
		dailyScrollPane = createScrollPane('d');
		dailyScrollPane.setBounds(-1, -1, 793, 525);
		dailyScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	dailyScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	dailyScrollPane.getVerticalScrollBar().setUnitIncrement(10);
		dailyScrollPane.setVisible(false);

		weeklyScrollPane = createScrollPane('w');
		weeklyScrollPane.setBounds(-1, -1, 793, 525);
		weeklyScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	weeklyScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	weeklyScrollPane.getVerticalScrollBar().setUnitIncrement(10);
		weeklyScrollPane.setVisible(true);
	}

	public JPanel getMainPanel()
	{
		return mainPanel;
	}

	public String getInformation(char command)
	{
		return "";
	}

	public JButton getButton(char command)
	{
		return new JButton();
	}

	public JPanel getPanel(char command)
	{
		if(command == 'w')
			return weeklyForm;

		return dailyForm;
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
			return new Font("Avenir", Font.PLAIN, points);

		else if(style == 2)
			return new Font("Avenir", Font.ITALIC, points);

		return new Font("Avenir", Font.BOLD, points);
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

	public JPanel mainPanel;

	public JScrollPane dailyScrollPane;
	public JScrollPane weeklyScrollPane;

	public JPanel dailyForm;
	public JPanel weeklyForm;

	private Font headerFont;
	private Font eventFont;

	private Color green;
	private Color darkGreen;
	private Color white;
	private Color grey;
	private Color lightGrey;
	private Color freeColor;
	private Color reservedColor;
}