package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	@Test
	public void testDefaultConstructor(){
		// TODO
		Coordinate coords = new Coordinate();
		Point point = new Point(coords);

		Assert.assertEquals(coords, point.getCoordinate());
		Assert.assertEquals("Point", point.getType());
		Assert.assertEquals(true , point.isEmpty());
	}
}
