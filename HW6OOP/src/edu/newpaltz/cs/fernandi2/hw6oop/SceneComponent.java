package edu.newpaltz.cs.fernandi2.hw6oop;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
/**
 * A component that shows a scene composed of shapes
 * @author ivan
 *
 */
public class SceneComponent extends JComponent {

	private ArrayList<SceneShape> shapes;
	private Point mousePoint;

	public SceneComponent() {
		shapes = new ArrayList<SceneShape>();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				boolean clicked = false;
				mousePoint = e.getPoint();
				for (SceneShape s : shapes) {
					if (s.contains(mousePoint)) {
						s.setSelected(true);
						clicked = true;
					}
				}
				if(!clicked){
					for (SceneShape s : shapes) {
						s.setSelected(false);
					}
				}
				repaint();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point lastMousePoint = mousePoint;
				mousePoint = e.getPoint();
				for (SceneShape s : shapes) {
					if(s.isSelected()){
						double dx = mousePoint.getX() - lastMousePoint.getX();
						double dy = mousePoint.getY() - lastMousePoint.getY();
						s.translate((int)dx, (int)dy);
					}
				}
				repaint();
			}
		});
	}

	/**
	 * Adds a shape to the scene
	 * 
	 * @param s
	 *            the shape to add
	 */
	public void add(SceneShape s) {
		shapes.add(s);
		repaint();
	}

	/**
	 * Removes all selected shapes from the scene
	 */
	public void removeSelected() {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			SceneShape s = shapes.get(i);
			if (s.isSelected())
				shapes.remove(i);
		}
		repaint();
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (SceneShape s : shapes) {
			s.draw(g2);
			if (s.isSelected())
				s.drawSelection(g2);
		}
	}
}
