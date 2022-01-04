package org.acme.geometry;

public interface GeometryVisitor {
    // Method
    public void visit(Point point);
    public void visit(LineString line);
    public void visit(GeometryCollection geometryCollection);

}