package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testWktPointEmpty() {
		// init
		Geometry pEmpty = new Point();
		Geometry lEmpty = new LineString();
		Geometry l = GeometryTestFactory.lineAB();
		Geometry p = GeometryTestFactory.ptA();
		WktVisitor writer = new WktVisitor();

		// test
		pEmpty.accept(writer);
		Assert.assertEquals(writer.getResult(), "POINT EMPTY");
		lEmpty.accept(writer);
		Assert.assertEquals(writer.getResult(), "LINESTRING EMPTY");
		p.accept(writer);
		Assert.assertEquals(writer.getResult(), "POINT(1.2 3.4)");
		l.accept(writer);
		Assert.assertEquals(writer.getResult(), "LINESTRING(1.2 3.4,5.6 7.8)");

	}
}
