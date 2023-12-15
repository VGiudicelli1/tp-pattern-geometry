package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryTestFactory {
	public final static LineString lineAB() {
		List<Point> lPts = new ArrayList<Point>();
		lPts.add(ptA());
		lPts.add(ptB());
		return new LineString(lPts);
	}

	public final static Point ptA() {
		return new Point(new Coordinate(1.2, 3.4));
	}

	public final static Point ptB() {
		return new Point(new Coordinate(5.6, 7.8));
	}
}
