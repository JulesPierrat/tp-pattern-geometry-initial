package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {

    // Attribute
    Geometry original;
    Envelope cachedEnvelope;

    // Constructor
    public GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
        this.cachedEnvelope = original.getEnvelope();
    }

    // Method
    public String getType() {
        return original.getType();
    }

    public boolean isEmpty() {
        return original.isEmpty();
    }

    public void translate(double dx, double dy) {
        original.translate(dx, dy);
    }

    public Geometry clone() {
        return new GeometryWithCachedEnvelope(this.original);
    }

    public Envelope getEnvelope() {
        return this.cachedEnvelope;
    }

    public void accept(GeometryVisitor visitor) {
        this.original.accept(visitor);      
    }    
    
}
