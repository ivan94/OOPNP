package edu.newpaltz.cs.fernandi2.hw6oop;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class SelectionShape extends SelectableShape {
	private double x1, y1, x2, y2;
	private double initX, initY;

	public SelectionShape(double x, double y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
		initX = x;
		initY = y;
	}

	@Override
	public void translate(int dx, int dy) {
		this.x1 += dx;
		this.x2 += dx;
		this.y1 += dy;
		this.y2 += dy;
	}

	@Override
	public void draw(Graphics2D g2) {
		Rectangle2D.Double r = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
		g2.draw(r);

	}

	@Override
	public boolean contains(Point2D p) {
		return x1 <= p.getX() && p.getX() <= x2 && y1 <= p.getY()
				&& p.getY() <= y2;
	}

	void setCorner(double x, double y) {
		if(x < initX){
			x1 = x;
		}else{
			x2 = x;
		}
		if(y < initY){
			y1 = y;
		}else{
			y2 = y;
		}
	}

	public boolean contains(Rectangle2D.Double r) {
		double rx1 = r.getX();
		double rx2 = rx1 + r.getWidth();
		double ry1 = r.getY();
		double ry2 = ry1 + r.getHeight();

		return ((rx1 <= x1 && x1 <= rx2) || (rx1 <= x2 && x2 <= rx2) || (x1 <= rx1 && x2 >= rx2))
				&& ((ry1 <= y1 && y1 <= ry2) || (ry1 <= y2 && y2 <= ry2) || (y1 <= ry1 && y2 >= ry2));

	}

	@Override
	public Rectangle2D.Double getSelectionArea() {
		return  new Rectangle2D.Double(x1, x2, x2 - x1, y2 - y1);
	}
}
