package org.acme.geometry;

public class Point extends AbstractGeometry {

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
		this.trigerChange();
	}

	@Override
	public Point clone() {
		return new Point(this.c);
	}

	@Override
	public <T> T accept(GeometryVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Coordinate getCoordinate() {
		return this.c;
	}
}
