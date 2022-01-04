package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
    
    @Test
    public void testDefaultGeometryWithCachedEnvelopeTest(){
        // Create Points
        Point point = new Point(new Coordinate(2.0 , 3.0));
        Point point2 = new Point(new Coordinate(4.0 , 5.0));

        // Create Line
        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point2);
        LineString line = new LineString(points);

        // Create geometry With cached envelope
        GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(line);
       
        // Calculate Envelope
        Envelope a = g.getEnvelope();
        Envelope b = g.getEnvelope();

        Assert.assertSame(a, b);
    }
}
