package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends AbstractGeometry {

	private List<Geometry> lGeom;

	public GeometryCollection() {
		this(new ArrayList<Geometry>());
	}

	public GeometryCollection(List<Geometry> lGeom) {
		this.lGeom = lGeom;
	}

	@Override
	public String getType() {
		return "GeometryCollection";
	}

	@Override
	public boolean isEmpty() {
		return this.lGeom.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		for (Geometry geom : this.lGeom) {
			geom.translate(dx, dy);
		}
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public GeometryCollection clone() {
		List<Geometry> newLGeom = new ArrayList<Geometry>();
		for (Geometry geom : this.lGeom) {
			newLGeom.add(geom.clone());
		}
		return new GeometryCollection(newLGeom);
	}

	public int getNumGeometries() {
		return this.lGeom.size();
	}

	public Geometry getGeometryN(int n) {
		return this.lGeom.get(n);
	}

}
