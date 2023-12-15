package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testEnvelopeBuilder() {
		// init & compute
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0, 1.0));
		builder.insert(new Coordinate(2.0, 0.0));
		builder.insert(new Coordinate(1.0, 3.0));
		Envelope result = builder.build();

		// test
		Assert.assertEquals(result.toString(), "0.0,2.0,0.0,3.0");
	}

	@Test
	public void testEnvelope() {
		// init & compute
		Envelope e1 = new Envelope();
		Envelope e2 = new Envelope(new Coordinate(1.2, 3.4), new Coordinate(5.6, 7.8));

		// test
		Assert.assertTrue(e1.isEmpty());
		Assert.assertEquals(e1.toString(), "NaN,NaN,NaN,NaN");

		Assert.assertFalse(e2.isEmpty());
		Assert.assertEquals(e2.toString(), "1.2,3.4,5.6,7.8");
		Assert.assertEquals(e2.getXmin(), 1.2, EPSILON);
		Assert.assertEquals(e2.getYmin(), 3.4, EPSILON);
		Assert.assertEquals(e2.getXmax(), 5.6, EPSILON);
		Assert.assertEquals(e2.getYmax(), 7.8, EPSILON);
	}

}