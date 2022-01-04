package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WriterFactoryTest {
    @Test
    public void testDefaultWriterFactory(){
        // Create Points
        Point point = new Point(new Coordinate(2.0 , 3.0));
        Point point2 = new Point(new Coordinate(4.0 , 5.0));
        Point point3 = new Point(new Coordinate(3.0 , 4.0));

        // Create Line
        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point2);
        LineString line = new LineString(points);

        // Create GeometryCollection
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(point3);
        geometries.add(line);
        GeometryCollection geometryCollection = new GeometryCollection(geometries);

        // Wkt
        WriterFactory factory = new WriterFactory();
        GeometryWriter wktWriter = factory.createGeometryWriter("WKT");
        String r = wktWriter.write(geometryCollection);
        
        // Test
        Assert.assertEquals("GEOMETRYCOLLECTION(POINT(3.0 4.0),LINESTRING(2.0 3.0,4.0 5.0)", r);
    }
}
