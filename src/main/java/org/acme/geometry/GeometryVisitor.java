package org.acme.geometry;

public interface GeometryVisitor {

	public void visit(Point p);

	public void visit(LineString l);
}
