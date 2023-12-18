package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryCollectionTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testGeometryCollectionEmpty() {
		GeometryCollection geom = new GeometryCollection();

		Assert.assertEquals(geom.getNumGeometries(), 0);
		Assert.assertTrue(geom.isEmpty());

		WktVisitor visitor = new WktVisitor();
		geom.accept(visitor);
		Assert.assertEquals(visitor.getResult(), "GEOMETRYCOLLECTION EMPTY");

		Assert.assertTrue(geom.getEnvelope().isEmpty());
		Assert.assertNotSame(geom, geom.clone());

		Assert.assertEquals(geom.getType(), "GeometryCollection");
	}

	@Test
	public void testGeometryCollectionPointLine() {
		GeometryCollection geom = GeometryTestFactory.collection1();

		Assert.assertEquals(geom.getNumGeometries(), 2);
		Assert.assertFalse(geom.isEmpty());

		WktVisitor visitor = new WktVisitor();
		geom.accept(visitor);
		Assert.assertEquals(visitor.getResult(), "GEOMETRYCOLLECTION(POINT(1.2 3.4),LINESTRING(1.2 3.4,5.6 7.8))");

		Envelope envelope = geom.getEnvelope();
		Assert.assertFalse(envelope.isEmpty());
		Assert.assertEquals(envelope.toString(), "1.2,3.4,5.6,7.8");

		GeometryCollection geomClone = geom.clone();
		geom.translate(1.0, 1.1);
		Assert.assertEquals(geomClone.asText(), "GEOMETRYCOLLECTION(POINT(1.2 3.4),LINESTRING(1.2 3.4,5.6 7.8))");
		Assert.assertEquals(geom.asText(), "GEOMETRYCOLLECTION(POINT(2.2 4.5),LINESTRING(2.2 4.5,6.6 8.9))");
	}
}