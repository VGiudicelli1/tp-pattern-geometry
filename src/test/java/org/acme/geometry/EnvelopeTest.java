package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testEnvelopeBuilder() {
		// init & compute
		EnvelopeBuilder builder = new EnvelopeBuilder();
		Envelope resultEmpty = builder.build();
		builder.insert(new Coordinate(0.0, 1.0));
		builder.insert(new Coordinate(2.0, 0.0));
		builder.insert(new Coordinate(1.0, 3.0));
		Envelope result = builder.build();

		// test
		Assert.assertTrue(resultEmpty.isEmpty());
		Assert.assertEquals(result.toString(), "0.0,0.0,2.0,3.0");
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

		Assert.assertFalse(new Envelope(new Coordinate(1.2, 3.4), new Coordinate(5.6, 7.8)).isEmpty());
		Assert.assertTrue(new Envelope(null, new Coordinate(5.6, 7.8)).isEmpty());
		Assert.assertTrue(new Envelope(new Coordinate(1.2, 3.4), null).isEmpty());
		Assert.assertTrue(new Envelope(new Coordinate(), new Coordinate(5.6, 7.8)).isEmpty());
		Assert.assertTrue(new Envelope(new Coordinate(1.2, 3.4), new Coordinate()).isEmpty());
	}

	@Test
	public void testEnvelopePoint() {
		Point p = new Point(new Coordinate(1.2, 3.4));
		Assert.assertEquals(p.getEnvelope().toString(), "1.2,3.4,1.2,3.4");

		List<Point> lPts = new ArrayList<Point>();
		lPts.add(p);
		lPts.add(new Point(new Coordinate(5.6, 7.8)));
		LineString l = new LineString(lPts);

		Assert.assertEquals(l.getEnvelope().toString(), "1.2,3.4,5.6,7.8");
	}

}
