package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeoJSONWriterTest {
    @Test
    public void testDefaultGeoJSONWriter(){
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

        // Create GeoJSONWriter
        GeoJSONWriter writer = new GeoJSONWriter();
        String r = writer.write(geometryCollection);

        GeoJSONWriter w2 = new GeoJSONWriter();
        String r2 = w2.write(point);

        GeoJSONWriter w3 = new GeoJSONWriter();
        String r3 = w3.write(line);

        // Test
        Assert.assertEquals("{'type': 'FeaturesCollection', 'features': [{'type': 'Feature', 'geometry': {'type': 'Point', 'coordinate': [3.0, 4.0]}},{'type': 'Feature', 'geometry': {'type': 'LineString', 'coordinate': [[2.0, 3.0],[4.0, 5.0]]}}]}", r);
        Assert.assertEquals("{'type': 'FeaturesCollection', 'features': [{'type': 'Feature', 'geometry': {'type': 'Point', 'coordinate': [2.0, 3.0]}}]}", r2);
        Assert.assertEquals("{'type': 'FeaturesCollection', 'features': [{'type': 'Feature', 'geometry': {'type': 'LineString', 'coordinate': [[2.0, 3.0],[4.0, 5.0]]}]}", r3);

    }
}
