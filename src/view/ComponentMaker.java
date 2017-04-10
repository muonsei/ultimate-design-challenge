package view;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;

public interface ComponentMaker
{
	public JPanel createPanel();
	public JButton createButton(String content);
	public JTextField createField(String content);
	public Color createColor(int red, int green, int blue);
	public LineBorder createBorder(Color color, int thickness);
	public Font createFont(int style, int points);
	public JCheckBox createCheckBox(String content);
	public JRadioButton createRadio(String content);
	public JComboBox createComboBox();
	public JLabel createLabel(String content);

	public JPanel getMainPanel();
	public String getInformation(char command);
	public JButton getButton(char command);
	public JPanel getPanel(char command);
	public void updateDetails();
}