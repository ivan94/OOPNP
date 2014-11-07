package edu.newpaltz.cs.fernandi2.hw6oop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A program that allows users to edit a scene composed of items.
 * 
 * @author ivan
 *
 */
public class SceneEditor {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final SceneComponent scene = new SceneComponent();

		JButton houseButtom = new JButton("House");
		houseButtom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scene.add(new HouseShape(20, 20, 50));
			}
		});
		
		JButton carButtom = new JButton("Car");
		carButtom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scene.add(new CarShape(20, 20, 50));
			}
		});
		
		JButton removeButtom = new JButton("Remove");
		removeButtom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scene.removeSelected();
			}
		});
		
		JPanel buttons = new JPanel();
		buttons.add(houseButtom);
		buttons.add(carButtom);
		buttons.add(removeButtom);
		
		frame.add(scene, BorderLayout.CENTER);
		frame.add(buttons, BorderLayout.NORTH);
		frame.setSize(300,300);
		frame.setVisible(true);

	}
}
