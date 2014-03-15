package swingTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableCellRendererJComboBox extends JFrame {
	protected JTable table;

	public static void main(String[] args) {
		TableCellRendererJComboBox stt = new TableCellRendererJComboBox();
		stt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stt.setSize(400, 200);
		stt.setVisible(true);
	}

	public TableCellRendererJComboBox() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		TableValues tv = new TableValues();
		table = new JTable(tv);
		table.setGridColor(Color.black);
		TableColumnModel tcm = table.getColumnModel();
		TableColumn tc = tcm.getColumn(TableValues.GENDER);
		tc.setCellRenderer(new GenderRenderer());
		JScrollPane jsp = new JScrollPane(table);
		pane.add(jsp, BorderLayout.CENTER);
	}

}

class TableValues extends AbstractTableModel {
	public final static int FIRST_NAME = 0;
	public final static int LAST_NAME = 1;
	public final static int DATE_OF_BIRTH = 2;
	public final static int ACCOUNT_BALANCE = 3;
	public final static int GENDER = 4;
	public final static boolean GENDER_MALE = true;
	public final static boolean GENDER_FEMALE = false;

	public Object[][] values = {
			{ "C", "A", new GregorianCalendar(1962, Calendar.FEBRUARY, 20).getTime(),new Float(1.67), new Boolean(GENDER_MALE) },
			{ "J", "A", new GregorianCalendar(1987, Calendar.JANUARY, 6).getTime(),new Float(2.78), new Boolean(GENDER_MALE) },
			{ "J", "A", new GregorianCalendar(1989, Calendar.AUGUST, 31).getTime(),new Float(3.89), new Boolean(GENDER_FEMALE) },
			{ "E", "K", new GregorianCalendar(1945, Calendar.JANUARY, 16).getTime(),new Float(-4.70), new Boolean(GENDER_FEMALE) },
			{ "B", "S", new GregorianCalendar(1907, Calendar.AUGUST, 2).getTime(),new Float(5.00), new Boolean(GENDER_FEMALE) }
	};


	public int getRowCount() {
		return values.length;
	}

	public int getColumnCount() {
		return values[0].length;
	}

	public Object getValueAt(int row, int column) {
		return values[row][column];
	}

}