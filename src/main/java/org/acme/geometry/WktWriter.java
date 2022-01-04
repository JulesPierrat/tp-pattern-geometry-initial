package org.acme.geometry;

public class WktWriter implements GeometryWriter{
    // Attribute

    // Constructor
    public WktWriter(){

    }
    
    // Method
    public String getName() {
        return "WKT";
    }
    
    public String write(Geometry geometry){
        WktVisitor visitor = new WktVisitor();
        geometry.accept(visitor);
        return visitor.getResult();
    }
}