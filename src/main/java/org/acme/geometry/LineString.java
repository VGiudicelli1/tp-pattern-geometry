package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {

	private List<Point> lPts;

	public LineString() {
		this.lPts = new ArrayList<Point>();
	}

	public LineString(List<Point> l) {
		if (l == null || l.size() == 1) {
			this.lPts = new ArrayList<Point>();
		} else {
			this.lPts = l;
		}
	}

	@Override
	public String getType() {
		return "LineString";
	}

	@Override
	public boolean isEmpty() {
		return this.lPts.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		for (Point p : this.lPts) {
			p.translate(dx, dy);
		}
	}

	@Override
	public LineString clone() {
		List<Point> lNewPts = new ArrayList<Point>();
		for (Point p : this.lPts) {
			lNewPts.add(p.clone());
		}
		return new LineString(lNewPts);
	}

	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		for (Point p : this.lPts) {
			builder.insert(p.getCoordinate());
		}
		return builder.build();
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public int getNumPoints() {
		return this.lPts.size();
	}

	public Point getPointN(int n) {
		return this.lPts.get(n);
	}
}
