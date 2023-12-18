package org.acme.geometry;

public interface Geometry {

	public String getType();

	public boolean isEmpty();

	public void translate(double dx, double dy);

	public Geometry clone();

	public Envelope getEnvelope();

	public <T> T accept(GeometryVisitor<T> visitor);

	public String asText();

	public void addListener(GeometryListener listener);
}
