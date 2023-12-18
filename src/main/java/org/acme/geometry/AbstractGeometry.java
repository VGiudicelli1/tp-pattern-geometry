package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {

	private List<GeometryListener> listeners;

	public AbstractGeometry() {
		this.listeners = new ArrayList<GeometryListener>();
	}

	@Override
	public abstract AbstractGeometry clone();

	public String asText() {
		WktVisitor visitor = new WktVisitor();
		this.accept(visitor);
		return visitor.getResult();
	}

	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		this.accept(builder);
		return builder.build();
	}

	@Override
	public void addListener(GeometryListener listener) {
		this.listeners.add(listener);
	}

	protected void trigerChange() {
		for (GeometryListener listener : this.listeners) {
			listener.onChange(this);
		}
	}

}
