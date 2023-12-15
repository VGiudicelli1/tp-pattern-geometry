package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

	@Override
	public abstract AbstractGeometry clone();

	public String asText() {
		WktVisitor visitor = new WktVisitor();
		this.accept(visitor);
		return visitor.getResult();
	}

}