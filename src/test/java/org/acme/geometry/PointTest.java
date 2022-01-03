package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		// TODO
		Coordinate coords = new Coordinate();
		Point point = new Point(coords);

		Assert.assertEquals(coords, point.getCoordinate());
		Assert.assertEquals("Point", point.getType());
		Assert.assertEquals(true , point.isEmpty());

	}

	public void testDefaultTranslation(){
		Point point = new Point(new Coordinate(0.0, 0.0));
		Point point2 = new Point(new Coordinate(2.0, 2.0));
		Point point3 = new Point(new Coordinate());
		point.translate(2.0, 2.0);
		point3.translate(2.0, 2.0);


		Assert.assertEquals(point2.getCoordinate().getX(), point.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(point2.getCoordinate().getY(), point.getCoordinate().getY(), EPSILON);
		Assert.assertEquals(point2.getCoordinate().getX(), point3.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(point2.getCoordinate().getY(), point3.getCoordinate().getY(), EPSILON);

	}
}
