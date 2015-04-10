package swingTable;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

class GenderRenderer extends JComboBox implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenderRenderer() {
		super();
		addItem("Male");
		addItem("Female");
		addItem("Complete");
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {

		if (isSelected) {
			setForeground(table.getSelectionForeground());
			super.setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(table.getBackground());
		}

		boolean isMale = ((Boolean) value).booleanValue();
		setSelectedIndex(isMale ? 0 : 1);
		return this;
	}
}


