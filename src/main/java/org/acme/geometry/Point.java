package org.acme.geometry;

public class Point implements Geometry {
	
	private Coordinate c;
	
	public Point() {
		this.c = new Coordinate();
	}
	
	public Point(Coordinate c) {
		this.c = c;
	}

	@Override
	public String getType() {
		return "Point";
	}

	public Coordinate getCoordinate() {
		return this.c;
	}

}
