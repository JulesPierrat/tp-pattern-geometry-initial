package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeometryCollectionTest {
    @Test
    public void testDefaultGeometryCollectionConstructor(){
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

        // test
        Assert.assertSame(point3, geometryCollection.getGeometryN(0));
        Assert.assertEquals(2, geometryCollection.getNumGeometries());
    }

    @Test
    public void testDefaultGeometryColectionWkt(){
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

        // Test
        WktVisitor visitor = new WktVisitor();
        geometryCollection.accept(visitor);
        Assert.assertEquals("GEOMETRYCOLLECTION(POINT(3.0 4.0),LINESTRING(2.0 3.0,4.0 5.0)", visitor.getResult());

    }
}
