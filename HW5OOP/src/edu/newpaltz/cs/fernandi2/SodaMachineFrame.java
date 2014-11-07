package edu.newpaltz.cs.fernandi2;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SodaMachineFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public SodaMachineFrame() {
		this.initComponents();
	}

	private void initComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Soda Machine");
		this.setResizable(false);
		
		this.setLayout(new GridLayout(0, 2));
		JLabel coinEntryLabel = new JLabel("Coin Entry");
		coinEntryLabel.setFont(new Font(coinEntryLabel.getFont().getName(), Font.BOLD, 20));
		JPanel p = new JPanel(new FlowLayout());
		p.setAlignmentX(LEFT_ALIGNMENT);
		p.add(coinEntryLabel);
		this.add(p);
		this.add(new JPanel());
		
		JPanel coinButtons = new JPanel();
		coinButtons.setLayout(new FlowLayout());
		coinButtons.add(new JButton("5"));
		coinButtons.add(new JButton("10"));
		coinButtons.add(new JButton("25"));
		this.add(coinButtons);
		this.add(new JPanel());
		
		JPanel totalDisplay = new JPanel(new FlowLayout());
		totalDisplay.add(new JLabel("Total"));
		JTextField totalText = new JTextField();
		totalText.setEditable(false);
		totalDisplay.add(totalText);
		this.add(totalDisplay);
		
		JPanel coinReturnArea = new JPanel(new FlowLayout());
		coinReturnArea.add(new JButton("COIN Return"));
		this.add(coinReturnArea);
		
		
		this.pack();
	}
	
	public static void main(String[] args) {
		(new SodaMachineFrame()).setVisible(true);
	}
	

}
