package org.acme.geometry;

public class WktWriter {
	public String write(Geometry geometry) {
		if (geometry instanceof Point) {
			Point point = (Point) geometry;
			if (point.isEmpty())
				return "POINT EMPTY";
			return "POINT(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")";
		} else if (geometry instanceof LineString) {
			LineString lineString = (LineString) geometry;
			if (lineString.isEmpty())
				return "LINESTRING EMPTY";
			String wkt = "LINESTRING(";
			for (int i = 0; i < lineString.getNumPoints(); i++) {
				Coordinate c = lineString.getPointN(i).getCoordinate();
				if (i != 0)
					wkt += ",";
				wkt += c.getX() + " " + c.getY();
			}
			return wkt + ")";
		} else {
			throw new RuntimeException("geometry type not supported");
		}
	}
}
