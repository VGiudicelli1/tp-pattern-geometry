package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryCachedEnvelopeTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testSameCache() {
		Geometry g = new Point(new Coordinate(3.0, 3.0));
		// décoration
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope(); // calcul et stockage dans cachedEnvelope
		Envelope b = g.getEnvelope(); // renvoi de cachedEnvelope
		Assert.assertSame(a, b);
	}

	@Test
	public void testSameMethods() {
		Geometry gO = GeometryTestFactory.ptB(); // original
		Geometry gD = new GeometryWithCachedEnvelope(gO); // decorated
		WktVisitor visitor = new WktVisitor();

		Assert.assertEquals(gO.asText(), gD.asText());

		gO.accept(visitor);
		String s1 = visitor.getResult();
		gD.accept(visitor);
		Assert.assertEquals(s1, visitor.getResult());

		Assert.assertEquals(gO.getType(), gD.getType());
		Assert.assertEquals(gO.isEmpty(), gD.isEmpty());

		// clone
		Geometry gDclone = gD.clone();

		gDclone.translate(5.0, 2.0);
		Assert.assertNotEquals(gD.asText(), gDclone.asText());

		gO.translate(5.0, 2.0);
		Assert.assertEquals(gD.asText(), gDclone.asText());
	}
}
