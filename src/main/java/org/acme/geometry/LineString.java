package org.acme.geometry;

import java.util.List;

public class LineString implements Geometry {
    // Attributes
    private List<Point> points;

    // Constructors
    public LineString(){
        this.points.add(new Point());
    }
    public LineString(List<Point> points){
        this.points = points;
    }

    // Getters
    public int getNumPoints(){
        return this.points.size();
    }

    public Point getPointN(int n){
        return this.points.get(n);
    }

    // Method
    public String getType(){
        return "LineString";
    }    
}