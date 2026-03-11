/**
 * 
 */

/**
 * @author uroojarshad
 *
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI implements ActionListener {
	//Window components
	JFrame frame;
	JTextField display;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[4];
	JButton addB, subB, multB, divB;
	JButton eqB, clrB;
	JPanel panel;
	
	double num1 = 0, num2 = 0, result = 0;
	char   operator;
	
	CalculatorGUI(){
		frame = new JFrame("Java GUI Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		display = new JTextField();
		display.setBounds(50, 25, 300, 50);
		display.setEditable(false);
		
		//Define buttons
		addB = new JButton("+");
		subB = new JButton("-");
		multB = new JButton("*");
		divB = new JButton("/");
		eqB = new JButton("=");
		clrB = new JButton("Clear");
		
		functionButtons[0] = addB;
		functionButtons[1] = subB;
		functionButtons[2] = multB;
		functionButtons[3] = divB;
		
		for(int i = 0; i < 4; i++) {
			functionButtons[i].addActionListener(this);
		}
		for(int i = 0; i < 10; i++){
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
		}
		eqB.addActionListener(this);
		clrB.addActionListener(this);
		
		//Layout panel
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		//Adding buttons to panel (Row by Row);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addB);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subB);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multB);
		panel.add(clrB);
		panel.add(numberButtons[0]);
		panel.add(eqB);
		panel.add(divB);
		
		frame.add(panel);
		frame.add(display);
		frame.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculatorGUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				display.setText(display.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == clrB) {
			display.setText("");
		}
		if(e.getSource() == addB) {
			num1 = Double.parseDouble(display.getText());
			operator = '+';
			display.setText("");
		}
		if(e.getSource() == subB) {
			num1 = Double.parseDouble(display.getText());
			operator = '-';
			display.setText("");
		}
		if(e.getSource() == multB) {
			num1 = Double.parseDouble(display.getText());
			operator = '*';
			display.setText("");
		}
		if(e.getSource() == divB) {
			num1 = Double.parseDouble(display.getText());
			operator = '/';
			display.setText("");
		}
		if(e.getSource() == eqB) {
			num2 = Double.parseDouble(display.getText());
			switch(operator) {
			case '+': result = num1 + num2; break;
			case '-': result = num1 - num2; break;
			case '*': result = num1 * num2; break;
			case '/': result = num1 / num2; break;
			}
			display.setText(String.valueOf(result));
			num1 = result;
		}	
	}
}





























