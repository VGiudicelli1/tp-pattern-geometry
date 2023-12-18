package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener {

	private Geometry original;

	private Envelope cachedEnvelope;

	public GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
		this.cachedEnvelope = new Envelope();
		this.addListener(this);
	}

	@Override
	public String getType() {
		return this.original.getType();
	}

	@Override
	public boolean isEmpty() {
		return this.original.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		this.original.translate(dx, dy);
	}

	@Override
	public Envelope getEnvelope() {
		if (this.cachedEnvelope.isEmpty()) {
			this.cachedEnvelope = this.original.getEnvelope();
		}
		return this.cachedEnvelope;
	}

	@Override
	public <T> T accept(GeometryVisitor<T> visitor) {
		return this.original.accept(visitor);
	}

	@Override
	public String asText() {
		return this.original.asText();
	}

	@Override
	public GeometryWithCachedEnvelope clone() {
		return new GeometryWithCachedEnvelope(this.original.clone());
	}

	@Override
	public void onChange(Geometry newGeometry) {
		this.cachedEnvelope = new Envelope(); // invalidation of envelope compute
	}

	@Override
	public void addListener(GeometryListener listener) {
		this.original.addListener(listener);
	}

}
