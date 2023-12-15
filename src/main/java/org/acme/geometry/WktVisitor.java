package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {
	private String buffer = "";

	@Override
	public void visit(Point p) {
		if (p.isEmpty())
			this.buffer = "POINT EMPTY";
		else
			this.buffer = "POINT(" + p.getCoordinate().getX() + " " + p.getCoordinate().getY() + ")";
	}

	@Override
	public void visit(LineString l) {
		if (l.isEmpty())
			this.buffer = "LINESTRING EMPTY";
		else {
			this.buffer = "LINESTRING(";
			for (int i = 0; i < l.getNumPoints(); i++) {
				Coordinate c = l.getPointN(i).getCoordinate();
				if (i != 0)
					this.buffer += ",";
				this.buffer += c.getX() + " " + c.getY();
			}
			this.buffer += ")";
		}
	}

	public String getResult() {
		return this.buffer;
	}

}
