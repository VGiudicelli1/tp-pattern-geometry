package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.Assert;

public class LogGeometryVisitorTest {
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testLogPointEmpty() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);

		Geometry p = new Point();
		p.accept(visitor);
		Assert.assertEquals(os.toString(), "Je suis un point vide.\n");
	}

	@Test
	public void testLogPointNonEmpty() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);

		Geometry p = GeometryTestFactory.ptA();
		p.accept(visitor);
		Assert.assertEquals(os.toString(), "Je suis un point avec x=1.2 et y=3.4.\n");
	}

	@Test
	public void testLogLineEmpty() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);

		Geometry l = new LineString();
		l.accept(visitor);
		Assert.assertEquals(os.toString(), "Je suis une polyligne vide.\n");
	}

	@Test
	public void testLogLineNonEmpty() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);

		Geometry l = GeometryTestFactory.lineAB();
		l.accept(visitor);
		Assert.assertEquals(os.toString(), "Je suis une polyligne définie par 2 points.\n");
	}
}
