package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
    
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
	}
}
