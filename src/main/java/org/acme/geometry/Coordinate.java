package org.acme.geometry;

public class Coordinate {

	private double x, y;

	public Coordinate() {
		this.x = Double.NaN;
		this.y = Double.NaN;
	}

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean isEmpty() {
		return Double.isNaN(this.x) || Double.isNaN(this.y);
	}

	public String toString() {
		return "[" + this.x + "," + this.y + "]";
	}

	public static final Coordinate EMPTY = new Coordinate();
}
