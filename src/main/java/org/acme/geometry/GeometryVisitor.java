package org.acme.geometry;

public interface GeometryVisitor<T> {

	public T visit(Point p);

	public T visit(LineString l);

	public T visit(GeometryCollection c);
}
