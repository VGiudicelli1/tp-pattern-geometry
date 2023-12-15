package org.acme.geometry;

public class Point implements Geometry {

	private Coordinate c;

	public Point() {
		this.c = Coordinate.EMPTY;
	}

	public Point(Coordinate c) {
		this.c = c != null ? c : Coordinate.EMPTY;
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
		this.c = new Coordinate(this.c.getX() + dx, this.c.getY() + dy);
	}

	@Override
	public Point clone() {
		return new Point(this.c);
	}

	@Override
	public Envelope getEnvelope() {
		return new EnvelopeBuilder().insert(c).build();
	}

	public Coordinate getCoordinate() {
		return this.c;
	}
}
