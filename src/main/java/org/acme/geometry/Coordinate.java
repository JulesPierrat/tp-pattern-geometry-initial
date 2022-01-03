package org.acme.geometry;

public class Coordinate {
    // Attributes
    private double x;
    private double y;

    // Constructors
    public Coordinate(){
        this.x = 0.0;
        this.y = 0.0;
    };
    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
