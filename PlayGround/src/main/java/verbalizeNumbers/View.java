package verbalizeNumbers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame{
	private JButton convertButton = new JButton("Convert");
	private JTextField inputField = new JTextField(15);
	private JTextArea outputField = new JTextArea(5,15);
	private handler handle = new handler();
	
	public View() {
		setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		outputField.setEditable(false);
		convertButton.addActionListener(handle);
		
		add(inputField);
		add(convertButton);
		add(outputField);

		pack();
		setVisible(true);
	}
	
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == convertButton){
				outputField.setText(NumberConverter.convertNumberToWord(inputField.getText()));
			}
		}
	}
	
	
	public static void main(String[] args){
		View v = new View();
	}
}
