package edu.newpaltz.cs.fernandi2.hw6oop;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public abstract class CompoundShape extends SelectableShape{
	private GeneralPath path;

	public CompoundShape() {
		path = new GeneralPath();
	}
	
	protected void add(Shape s) {
		path.append(s, false);
	}
	
	@Override
	public boolean contains(Point2D p) {
		return path.contains(p);
	}
	
	@Override
	public void translate(int dx, int dy) {
		path.transform(AffineTransform.getTranslateInstance(dx, dy));
	}
	
	@Override
	public void draw(Graphics2D g2) {
		g2.draw(path);
	}
}
