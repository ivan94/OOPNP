package edu.newpaltz.cs.fernandi2.hw6oop;

import java.awt.Graphics2D;

/**
 *  A shape that manages its selection state
 * @author ivan
 *
 */
public abstract class SelectableShape implements SceneShape{
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public void drawSelection(Graphics2D g2){
		translate(1, 1);
		draw(g2);
		translate(1, 1);
		draw(g2);
		translate(-2, -2);
	}
}
