import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Arturo III
 */
public class TableRenderer extends DefaultTableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            setBackground(new Color(240, 241, 242));
            setBorder(null);
            setForeground(Color.black);
            setHorizontalAlignment(JTextField.CENTER);
            setFont(new Font("Avenir Next", Font.BOLD, 7));

            return this;  
    }
}
