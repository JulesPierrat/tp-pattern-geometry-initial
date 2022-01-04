package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AbstractGeometryTest {

    public static final double EPSILON = 1.0e-15;
    
    @Test
    public void testDefaultAbstractGeometryAsText(){
        // Create Points
        Point point = new Point(new Coordinate(2.0 , 3.0));
        Point point2 = new Point(new Coordinate(4.0 , 5.0));

        // Create Line
        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point2);
        LineString line = new LineString(points);

        // Tets
        Assert.assertEquals("POINT(2.0 3.0)", point.asText());
        Assert.assertEquals("LINESTRING(2.0 3.0,4.0 5.0)", line.asText());
    }

    @Test
    public void testDefaultAbstractGeometryGetEnvelope(){
        // Create Points
        Point point = new Point(new Coordinate(2.0 , 3.0));
        Point point2 = new Point(new Coordinate(4.0 , 5.0));

        // Create Line
        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point2);
        LineString line = new LineString(points);

        Assert.assertEquals(2.0, point.getEnvelope().getXmin(), EPSILON);
        Assert.assertEquals(2.0, point.getEnvelope().getXmax(), EPSILON);
        Assert.assertEquals(3.0, point.getEnvelope().getYmin(), EPSILON);
        Assert.assertEquals(3.0, point.getEnvelope().getYmax(), EPSILON);

        Assert.assertEquals(2.0, line.getEnvelope().getXmin(), EPSILON);
        Assert.assertEquals(4.0, line.getEnvelope().getXmax(), EPSILON);
        Assert.assertEquals(3.0, line.getEnvelope().getYmin(), EPSILON);
        Assert.assertEquals(5.0, line.getEnvelope().getYmax(), EPSILON);


    }
}
