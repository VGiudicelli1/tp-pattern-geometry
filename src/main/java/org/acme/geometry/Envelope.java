package org.acme.geometry;

public class Envelope {
	private Coordinate bottomLeft, topRight;

	public Envelope() {

	}

	public Envelope(Coordinate botomLeft, Coordinate topRight) {

	}

	public boolean isEmpty() {
		return true;
	}

	public double getXmin() {
		return 0;
	}

	public double getXmax() {
		return 0;
	}

	public double getYmin() {
		return 0;
	}

	public double getYmax() {
		return 0;
	}

	public String toString() {
		return "";
	}
}
