package org.acme.geometry;

public class LengthVisitor implements GeometryVisitor<Double> {

	@Override
	public Double visit(Point p) {
		return 0.0;
	}

	private double distPoints(Point p1, Point p2) {
		if (p1.isEmpty() /*|| p2.isEmpty() */ ) {
			return 0.0;
		}
		return 1.0;
	}

	@Override
	public Double visit(LineString l) {
		Point lastPt = new Point();
		double length = 0.0;
		for (int i = 0; i < l.getNumPoints(); i++) {
			length += distPoints(lastPt, l.getPointN(i));
			lastPt = l.getPointN(i);
		}
		return length;
	}

	@Override
	public Double visit(GeometryCollection c) {
		double length = 0.0;
		for (int i = 0; i < c.getNumGeometries(); i++) {
			length += c.getGeometryN(i).accept(this);
		}
		return length;
	}

}
