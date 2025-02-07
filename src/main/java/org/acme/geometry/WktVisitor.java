package org.acme.geometry;

public class WktVisitor implements GeometryVisitor<Void> {
	private StringBuilder buffer;

	@Override
	public Void visit(Point p) {
		this.buffer = new StringBuilder();
		if (p.isEmpty()) {
			this.buffer.append("POINT EMPTY");
		} else {
			this.buffer.append("POINT(" + p.getCoordinate().getX() + " " + p.getCoordinate().getY() + ")");
		}
		return null;
	}

	@Override
	public Void visit(LineString l) {
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
		return null;
	}

	public String getResult() {
		return this.buffer.toString();
	}

	@Override
	public Void visit(GeometryCollection c) {
		this.buffer = new StringBuilder();
		if (c.isEmpty()) {
			this.buffer.append("GEOMETRYCOLLECTION EMPTY");
		} else {
			this.buffer.append("GEOMETRYCOLLECTION(");
			WktVisitor wktVisitor = new WktVisitor();
			for (int i = 0; i < c.getNumGeometries(); i++) {
				if (i != 0) {
					this.buffer.append(",");
				}
				c.getGeometryN(i).accept(wktVisitor);
				this.buffer.append(wktVisitor.getResult());
			}
			this.buffer.append(")");
		}
		return null;
	}

}
