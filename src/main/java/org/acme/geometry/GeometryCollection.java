package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends AbstractGeometry{
    // Attribute
    private List<Geometry> geometries;

    // Constructors
    public GeometryCollection(){
        this.geometries = new ArrayList<>();
    }

    public GeometryCollection(List<Geometry> geometries){
        this.geometries = geometries;
    }

    // Method
    public String getType() {
        return "GeometryCollection";
    }

    public boolean isEmpty() {
        return (getNumGeometries() == 0);
    }

    public void translate(double dx, double dy) {
        for (Geometry geometry : geometries) {
            geometry.translate(dx, dy);
        }
    }

    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);        
    }

    public Geometry clone() {
        return new GeometryCollection(this.geometries);
    }

    public int getNumGeometries(){
        return this.geometries.size();
    }

    public Geometry getGeometryN(int n){
        return this.geometries.get(n);
    }

    
}
