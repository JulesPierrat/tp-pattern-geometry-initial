package org.acme.geometry;

public class Coordinate {
    // Attributes
    private double x;
    private double y;

    // Constructors
    public Coordinate(){
        this.x = Double.NaN;
        this.y = Double.NaN;
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

    // Method
    public boolean isEmpty(){
        return (Double.isNaN(this.x) || Double.isNaN(this.y));
    } 
}
