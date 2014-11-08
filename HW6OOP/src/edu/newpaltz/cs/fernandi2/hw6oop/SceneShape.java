package edu.newpaltz.cs.fernandi2.hw6oop;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public interface SceneShape {

	void translate(int dx, int dy);

	boolean isSelected();

	void setSelected(boolean selected);

	void drawSelection(Graphics2D g2);

	void draw(Graphics2D g2);

	boolean contains(Point2D p);
	
	Rectangle2D.Double getSelectionArea();
}
