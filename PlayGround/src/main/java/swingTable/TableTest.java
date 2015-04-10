package swingTable;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
public class TableTest extends JFrame {
	private JTable table;
	private JTableHeader header;
	private handler suckIt = new handler();

	public TableTest(){
		setup();
	}

	public void setup(){
		setTitle("Tables");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,1));

		Boolean[] vag = {new Boolean(true),new Boolean(false)};
		JComboBox vages = new JComboBox(vag);


		List<Object[]> initialData = new ArrayList<Object[]>();
		initialData.add(new Object[]{"Kathy", "Smith","Snowboarding", new Integer(5), new Boolean(false)});
		initialData.add(new Object[]{"John", "Doe","Rowing", new Integer(3), new Boolean(true)});
		initialData.add(new Object[]{"Sue", "Black","Knitting", new Integer(2), new Boolean(false)});
		initialData.add(new Object[]{"Jane", "White","Speed reading", new Integer(20), new Boolean(true)});
		initialData.add(new Object[]{"Joe", "Brown","Pool", new Integer(10), new Boolean(false)});

		List<String> columnNames = new ArrayList<String>();
		columnNames.add("USER_ID");
		columnNames.add("DESCRIPTION");
		columnNames.add("STATUS");
		columnNames.add("ADMIN_ID");
		columnNames.add("Vegetarian");

		Object[][] finalizedData = new Object[initialData.size()][];
		finalizedData = initialData.toArray(finalizedData);

		DefaultTableModel model = new DefaultTableModel(initialData.toArray(finalizedData), columnNames.toArray()) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return column==4;
			}
		};

		table = new JTable(model);
		table.setGridColor(Color.black);
		table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(vages));

		table.getModel().addTableModelListener(suckIt);

		header = table.getTableHeader();
		header.setBackground(Color.LIGHT_GRAY);

		add(new JScrollPane(table));
		pack();
		setVisible(true);
	}


	private class handler implements TableModelListener{
		public void tableChanged(TableModelEvent e) {
			int row = e.getFirstRow();
			int column = e.getColumn();
			TableModel model = (TableModel)e.getSource();
			String columnName = model.getColumnName(column);
			Object data = model.getValueAt(row, column);

			System.out.println(data.toString());
		}

	}


	public static void main(String[] args) {
		new TableTest();
	}

}
