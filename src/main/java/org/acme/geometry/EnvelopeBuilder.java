package org.acme.geometry;

public class EnvelopeBuilder implements GeometryVisitor<Void> {
	double xMin;
	double xMax;
	double yMin;
	double yMax;

	public EnvelopeBuilder() {
		this.xMin = Double.MAX_VALUE;
		this.xMax = Double.MIN_VALUE;
		this.yMin = Double.MAX_VALUE;
		this.yMax = Double.MIN_VALUE;
	}

	public EnvelopeBuilder insert(Coordinate c) {
		this.xMin = Math.min(this.xMin, c.getX());
		this.xMax = Math.max(this.xMax, c.getX());
		this.yMin = Math.min(this.yMin, c.getY());
		this.yMax = Math.max(this.yMax, c.getY());
		return this;
	}

	public Envelope build() {
		if (this.xMax < this.xMin) { // case any points
			return new Envelope();
		}
		return new Envelope(new Coordinate(this.xMin, this.yMin), new Coordinate(this.xMax, this.yMax));
	}

	@Override
	public Void visit(Point p) {
		this.insert(p.getCoordinate());
		return null;
	}

	@Override
	public Void visit(LineString l) {
		for (int i = 0; i < l.getNumPoints(); i++) {
			this.visit(l.getPointN(i));
		}
		return null;
	}

	@Override
	public Void visit(GeometryCollection c) {
		for (int i = 0; i < c.getNumGeometries(); i++) {
			c.getGeometryN(i).accept(this);
		}
		return null;
	}
}
