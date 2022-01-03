package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;
    
    @Test
	public void testDefaultConstructor(){
		// TODO
		Point point = new Point();
		List<Point> points = new ArrayList<>();
		points.add(point);
		LineString line = new LineString(points);

		Assert.assertEquals(point, line.getPointN(0));
		Assert.assertEquals("LineString", line.getType());
		Assert.assertEquals(1, line.getNumPoints());

		LineString line2 = new LineString();
		Assert.assertEquals(true, line2.isEmpty());
	}

	@Test
	public void testDefaultTranslation(){
		// TODO
		Point point1 = new Point(new Coordinate(1.0, 1.0));
		Point point2 = new Point(new Coordinate(2.0, 2.0));
		List<Point> points = new ArrayList<>();
		points.add(point1);
		points.add(point2);
		LineString line = new LineString(points);
		line.translate(-1.0, -1.0);

		Assert.assertEquals(0.0, line.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(0.0, line.getPointN(0).getCoordinate().getY(), EPSILON);
		Assert.assertEquals(1.0, line.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(1.0, line.getPointN(1).getCoordinate().getY(), EPSILON);
	}

	@Test
	public void TestDefaultClone(){
		Point point1 = new Point(new Coordinate(1.0, 1.0));
		Point point2 = new Point(new Coordinate(2.0, 2.0));
		List<Point> points = new ArrayList<>();
		points.add(point1);
		points.add(point2);
		LineString line = new LineString(points);

		LineString line1 = line;
		LineString copy = line.clone();
		copy.translate(10.0, 10.0);

		Assert.assertEquals(line1, line);
	}

	@Test
	public void TestDefaultGetEnvelope(){
		Point point1 = new Point(new Coordinate(1.0, 1.0));
		Point point2 = new Point(new Coordinate(2.0, 2.0));
		List<Point> points = new ArrayList<>();
		points.add(point1);
		points.add(point2);
		LineString line = new LineString(points);

		Envelope envelope = line.getEnvelope();

		Assert.assertEquals(1.0, envelope.getXmin(), EPSILON);
		Assert.assertEquals(1.0, envelope.getYmin(), EPSILON);
		Assert.assertEquals(2.0, envelope.getXmax(), EPSILON);
		Assert.assertEquals(2.0, envelope.getYmax(), EPSILON);
	}
}
