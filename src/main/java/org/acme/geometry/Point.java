package org.acme.geometry;

public class Point implements Geometry {

	private Coordinate c;

	public Point() {
		this.c = null;
	}

	public Point(Coordinate c) {
		this.c = c;
	}

	@Override
	public String getType() {
		return "Point";
	}

	@Override
	public boolean isEmpty() {
		return this.c == null;
	}

	@Override
	public void translate(double dx, double dy) {
		// TODO
	}

	public Coordinate getCoordinate() {
		return this.c;
	}
}
