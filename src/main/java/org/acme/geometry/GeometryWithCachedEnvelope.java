package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {

	private Geometry original;

	private Envelope cachedEnvelope;

	public GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
		this.cachedEnvelope = new Envelope();
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
	public void accept(GeometryVisitor visitor) {
		this.original.accept(visitor);
	}

	@Override
	public String asText() {
		return this.original.asText();
	}

	@Override
	public GeometryWithCachedEnvelope clone() {
		return new GeometryWithCachedEnvelope(this.original.clone());
	}

}