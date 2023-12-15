package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;

public class LineString implements Geometry {
	
	private List<Point> lPts;

	@Override
	public String getType() {
		return "LineString";
	}

	public LineString() {
		this.lPts = new ArrayList<Point>();
	}
	
	public LineString(List<Point> l) {
		if (l.size() == 1) {
			this.lPts = new ArrayList<Point>();
		} else {
			this.lPts = l;
		}
	}
	
	public int getNumPoints() {
		return this.lPts.size();
	}
	
	public Point getPointN(int n) {
		return this.lPts.get(n);
	}
}
