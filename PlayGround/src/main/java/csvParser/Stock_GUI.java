package csvParser;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

public class Stock_GUI extends JFrame {
	private JTextArea out = new JTextArea(10,15);
	private JTextField input = new JTextField("Enter stock symbols separated by spaces...",30);
	private JScrollPane output = new JScrollPane(out);
	private JButton startThread = new JButton("Start");
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	private CSV_Parser parser = new CSV_Parser();
	private TickerThread thread = new TickerThread(this);
	private handle doit = new handle();
	private JButton setInterval = new JButton("Set Interval");
	private JTextField interval = new JTextField("Enter time interval in minutes",15);
	private JButton setQuotes = new JButton("Set Quotes");
	
	private Integer[] mins = new Integer[30];
	private JComboBox intervals = new JComboBox();
	
	private int counter = -1;
	private JLabel inMins = new JLabel("In Minutes");
	
	private static Logger logger = Logger.getLogger(Stock_GUI.class);
	
	public Stock_GUI(){
		setup();
	}
	
	private void setup(){
		setTitle("Stock Quotes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(layout);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(input, c);
		
		setQuotes.addActionListener(doit);
		c.fill = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 0;
		add(setQuotes,c);

		
		for (int i = 0; i < 31; i++) {
			intervals.addItem(i);
		}
		
		intervals.addItemListener(doit);
		intervals.setEnabled(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		add(intervals,c);
		
		c.fill = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 1;
		add(inMins,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		add(output,c);
		
		startThread.setEnabled(false);
		startThread.addActionListener(doit);
		c.fill = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 2;
		add(startThread,c);
		
		pack();
		setVisible(true);
	}
	
	public void display(){
		counter++;
		List<String[]> newData = new ArrayList<String[]>();
		newData = parser.getQuotes();
		out.setText("Stock Quotes\nStocks have been updated "+counter+" times so far\n\n");
		
		for (String[] string : newData) {
			out.append(string[3] +" "+string[0]+" $"+new DecimalFormat("#.##").format(Double.parseDouble(string[1])));
			logger.info(string[3] +" "+string[0]+" $"+new DecimalFormat("#.##").format(Double.parseDouble(string[1])));
			System.out.println(string[3] +" "+string[0]+" $"+new DecimalFormat("#.##").format(Double.parseDouble(string[1])));
			out.append("\n");
		}
		System.out.println();
		out.invalidate();
	}
	
	private class handle implements ActionListener,ItemListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == startThread){
				thread.start();
			}
			if(e.getSource() == setQuotes){
				parser.setQuotes(input.getText());
				setInterval.setEnabled(true);
				intervals.setEnabled(true);
			}
		}

		public void itemStateChanged(ItemEvent e) {
			if(e.getSource() == intervals){
				thread.setTime(intervals.getSelectedIndex());
				startThread.setEnabled(true);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Stock_GUI();
	}

}
