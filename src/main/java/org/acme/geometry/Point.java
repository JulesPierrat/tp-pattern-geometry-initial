package org.acme.geometry;

public class Point implements Geometry {
    // Attributes
    private Coordinate coordinate;

    // Constructors
    public Point(){
        this.coordinate = new Coordinate();
    }
    public Point(Coordinate coordinate){
        if (coordinate == null) {
            this.coordinate = new Coordinate();
        } else {
            this.coordinate = coordinate;
        }
    }

    // Getters
    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    // Method
    public String getType(){
        return "Point";
    }

    public boolean isEmpty(){
        return this.coordinate.isEmpty();
    }
}
