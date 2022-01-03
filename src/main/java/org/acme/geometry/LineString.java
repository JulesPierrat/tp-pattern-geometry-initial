package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
    // Attributes
    private List<Point> points = new ArrayList<>();

    // Constructors
    public LineString(){
        this.points = new ArrayList<>();
    }
    public LineString(List<Point> points){
        if (points == null) {
            this.points = new ArrayList<>();
        } else {
            this.points = points;
        }
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

    public boolean isEmpty(){
        return (this.getNumPoints() == 0);
    }

    public void translate (double dx, double dy){
        if (! isEmpty()) {
            for(int i = 0 ; i < getNumPoints() ; i++){
                getPointN(i).translate(dx, dy);
            }
        }
    }
}