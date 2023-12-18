package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {
	private PrintStream out;

	public LogGeometryVisitor() {
		this(System.out);
	}

	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}

	@Override
	public void visit(Point p) {
		if (p.isEmpty()) {
			this.out.println("Je suis un point vide.");
		} else {
			this.out.println(
					"Je suis un point avec x=" + p.getCoordinate().getX() + " et y=" + p.getCoordinate().getY() + ".");
		}
	}

	@Override
	public void visit(LineString l) {
		if (l.isEmpty()) {
			this.out.println("Je suis une polyligne vide.");
		} else {
			this.out.println("Je suis une polyligne définie par " + l.getNumPoints() + " points.");
		}
	}

	@Override
	public void visit(GeometryCollection c) {
		if (c.isEmpty()) {
			this.out.println("Je suis une collection vide.");
		} else {
			this.out.println("Je suis une collection définie par " + c.getNumGeometries() + " géométries.");
		}
	}

}
