package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class LengthVisitorTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testLength() {
		Geometry p = GeometryTestFactory.ptA();
		Geometry l = GeometryTestFactory.lineAB();
		Geometry c = GeometryTestFactory.collection1();
		LengthVisitor visitor = new LengthVisitor();

		Assert.assertEquals(p.accept(visitor), 0.0, EPSILON);
		Assert.assertEquals(l.accept(visitor), 1.0, EPSILON);
		Assert.assertEquals(c.accept(visitor), 1.0, EPSILON);
	}
}
