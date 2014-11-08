package edu.newpaltz.cs.fernandi2.hw6oop;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

/**
 * A house shape
 * 
 * @author ivan
 *
 */
public class HouseShape extends CompoundShape {
	private int x, y, width;

	public HouseShape(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		Rectangle2D.Double base = new Rectangle2D.Double(x, y + width, width,
				width);

		// The left bottom of the roof
		Point2D.Double r1 = new Point2D.Double(x, y + width);
		// The top of the roof
		Point2D.Double r2 = new Point2D.Double(x + width / 2, y);
		// The right bottom of the roof
		Point2D.Double r3 = new Point2D.Double(x + width, y + width);

		Line2D.Double roofLeft = new Line2D.Double(r1, r2);
		Line2D.Double roofRight = new Line2D.Double(r2, r3);

		add(base);
		add(roofLeft);
		add(roofRight);
	}

	@Override
	public Double getSelectionArea() {
		return new Rectangle2D.Double(x, y + width, width, width);
	}
	
	@Override
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
		super.translate(dx, dy);
	}
}
