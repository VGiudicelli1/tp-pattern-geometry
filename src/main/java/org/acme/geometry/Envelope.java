package org.acme.geometry;

public class Envelope {
	private Coordinate bottomLeft, topRight;

	public Envelope() {
		this(null, null);
	}

	public Envelope(Coordinate bottomLeft, Coordinate topRight) {
		if (bottomLeft == null || topRight == null || bottomLeft.isEmpty() || topRight.isEmpty()) {
			this.bottomLeft = Coordinate.EMPTY;
			this.topRight = Coordinate.EMPTY;
		} else {
			this.bottomLeft = bottomLeft;
			this.topRight = topRight;
		}
	}

	public boolean isEmpty() {
		return this.bottomLeft.isEmpty();
	}

	public double getXmin() {
		return this.bottomLeft.getX();
	}

	public double getXmax() {
		return this.topRight.getX();
	}

	public double getYmin() {
		return this.bottomLeft.getY();
	}

	public double getYmax() {
		return this.topRight.getY();
	}

	public String toString() {
		return this.getXmin() + "," + this.getYmin() + "," + this.getXmax() + "," + this.getYmax();
	}
}
