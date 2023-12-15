package org.acme.geometry;

public class Point implements Geometry {

	private Coordinate c;

	public Point() {
		this.c = new Coordinate();
	}

	public Point(Coordinate c) {
		if (c == null)
			this.c = new Coordinate();
		else
			this.c = c;
	}

	@Override
	public String getType() {
		return "Point";
	}

	@Override
	public boolean isEmpty() {
		return this.c.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		// TODO
	}

	public Coordinate getCoordinate() {
		return this.c;
	}
}
