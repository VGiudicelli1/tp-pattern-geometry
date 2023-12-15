package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testGeometryTestFactory() {
		GeometryTestFactory geometryTestFactory = new GeometryTestFactory();
		Assert.assertNotNull(geometryTestFactory);
	}

	@Test
	public void testWritePoint() {
		// init
		Geometry pEmpty = new Point();
		Geometry lEmpty = new LineString();
		Geometry l = GeometryTestFactory.lineAB();
		Geometry p = GeometryTestFactory.ptA();
		WktWriter writer = new WktWriter();

		// test
		Assert.assertEquals(writer.write(pEmpty), "POINT EMPTY");
		Assert.assertEquals(writer.write(lEmpty), "LINESTRING EMPTY");
		Assert.assertEquals(writer.write(p), "POINT(1.2 3.4)");
		Assert.assertEquals(writer.write(l), "LINESTRING(1.2 3.4,5.6 7.8)");
	}
}
