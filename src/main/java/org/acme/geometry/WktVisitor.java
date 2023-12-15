package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {
	private StringBuilder buffer;

	@Override
	public void visit(Point p) {
		this.buffer = new StringBuilder();
		if (p.isEmpty()) {
			this.buffer.append("POINT EMPTY");
		} else {
			this.buffer.append("POINT(" + p.getCoordinate().getX() + " " + p.getCoordinate().getY() + ")");
		}
	}

	@Override
	public void visit(LineString l) {
		this.buffer = new StringBuilder();
		if (l.isEmpty()) {
			this.buffer.append("LINESTRING EMPTY");
		} else {
			this.buffer.append("LINESTRING(");
			for (int i = 0; i < l.getNumPoints(); i++) {
				Coordinate c = l.getPointN(i).getCoordinate();
				if (i != 0) {
					this.buffer.append(",");
				}
				this.buffer.append(c.getX() + " " + c.getY());
			}
			this.buffer.append(")");
		}
	}

	public String getResult() {
		return this.buffer.toString();
	}

}
