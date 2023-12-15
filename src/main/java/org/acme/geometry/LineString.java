package org.acme.geometry;

import java.util.List;

public class LineString implements Geometry {
	
	private List<Point> lPts;

	@Override
	public String getType() {
		return "LineString";
	}

	public LineString() {
		this.lPts = null;
	}
	
	public LineString(List<Point> l) {
		this.lPts = l;
		if (this.getNumPoints() == 1)
			this.lPts = null;
	}
	
	public int getNumPoints() {
		if (this.isEmpty())
			return 0;
		else
			return this.lPts.size();
	}
	
	public Point getPointN(int n) {
		return this.lPts.get(n);
	}
	
	@Override
	public boolean isEmpty() {
		return this.lPts == null;
	}
}
