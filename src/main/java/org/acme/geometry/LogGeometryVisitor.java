package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor<Void> {
	private PrintStream out;

	public LogGeometryVisitor() {
		this(System.out);
	}

	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}

	@Override
	public Void visit(Point p) {
		if (p.isEmpty()) {
			this.out.println("Je suis un point vide.");
		} else {
			this.out.println(
					"Je suis un point avec x=" + p.getCoordinate().getX() + " et y=" + p.getCoordinate().getY() + ".");
		}
		return null;
	}

	@Override
	public Void visit(LineString l) {
		if (l.isEmpty()) {
			this.out.println("Je suis une polyligne vide.");
		} else {
			this.out.println("Je suis une polyligne définie par " + l.getNumPoints() + " points.");
		}
		return null;
	}

	@Override
	public Void visit(GeometryCollection c) {
		if (c.isEmpty()) {
			this.out.println("Je suis une collection vide.");
		} else {
			this.out.println("Je suis une collection définie par " + c.getNumGeometries() + " géométries.");
		}
		return null;
	}

}
