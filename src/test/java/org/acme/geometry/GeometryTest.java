package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeometryTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testLineString() {
		LineString l = new LineString();
		Assert.assertEquals("LineString", l.getType());
		Assert.assertEquals(l.getNumPoints(), 0);
		Assert.assertTrue(l.isEmpty());
		
		List<Point> lPts = new ArrayList<Point>();
		lPts.add(new Point(new Coordinate(1.4, 5.7)));
		LineString l2 = new LineString(lPts);
		Assert.assertEquals(l2.getNumPoints(), 0);
		Assert.assertTrue(l2.isEmpty());
		

		lPts.add(new Point(new Coordinate(7.2, 4.8)));
		LineString l3 = new LineString(lPts);
		
		Assert.assertEquals(l3.getNumPoints(), 2);
		Assert.assertEquals(l3.getPointN(1).getCoordinate().getX(), 7.2, EPSILON);
		Assert.assertFalse(l3.isEmpty());
		
		Assert.assertTrue(new LineString(null).isEmpty());
	}

	@Test
	public void testPoint() {
		Point p = new Point();
		Assert.assertEquals("Point", p.getType());
		Assert.assertTrue(p.isEmpty());
		
		Point p2 = new Point(new Coordinate(1.7, 5.9));
		Assert.assertEquals(p2.getCoordinate().getX(), 1.7, EPSILON);
		Assert.assertFalse(p2.isEmpty());

		Assert.assertTrue(new Point(null).isEmpty());
	}
	
	@Test
	public void testTranslate() {
		// init
		Point p = new Point(new Coordinate(5.3, 9.1));
		List<Point> lPts = new ArrayList<Point>();
		lPts.add(new Point(new Coordinate(1.6, 8.2)));
		lPts.add(new Point(new Coordinate(7.2, 3.5)));
		LineString l = new LineString(lPts);
		double dx = 1.3, dy = 5.2;
		Point pNull = new Point();
		LineString lNull = new LineString();
		
		// compute
		p.translate(dx,  dy);
		pNull.translate(dx, dy);
		l.translate(dx, dy);
		lNull.translate(dx, dy);
		
		// test
		Assert.assertEquals(p.getCoordinate().getX(), 5.3+dx, EPSILON);
		Assert.assertEquals(p.getCoordinate().getY(), 9.1+dy, EPSILON);
		Assert.assertEquals(pNull.getCoordinate().getX(), Double.NaN, EPSILON);
		Assert.assertEquals(pNull.getCoordinate().getY(), Double.NaN, EPSILON);

		Assert.assertEquals(l.getPointN(0).getCoordinate().getX(), 1.6+dx, EPSILON);
		Assert.assertEquals(l.getPointN(0).getCoordinate().getY(), 8.2+dy, EPSILON);
		Assert.assertEquals(l.getPointN(1).getCoordinate().getX(), 7.2+dx, EPSILON);
		Assert.assertEquals(l.getPointN(1).getCoordinate().getY(), 3.5+dy, EPSILON);
		Assert.assertEquals(lNull.getNumPoints(), 0);
	}
}
