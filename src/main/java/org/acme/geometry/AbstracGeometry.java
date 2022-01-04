package org.acme.geometry;

public abstract class AbstracGeometry implements Geometry{
    // Method
    public AbstracGeometry clone(){
        return this;
    }

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
        return visitor.getResult();
    };
}
