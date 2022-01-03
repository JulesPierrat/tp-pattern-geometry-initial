package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {
    // Attribute
    private List<Double> x = new ArrayList<>();
    private List<Double> y = new ArrayList<>();

    // Constructor
    public EnvelopeBuilder(){
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
    }

    // Method
    public void insert(Coordinate coordinate){
        this.x.add(coordinate.getX());
        this.y.add(coordinate.getY());
    }

    public Envelope build(){
        // set
        double xMin = Collections.min(this.x);
        double xMax = Collections.max(this.x);
        double yMin = Collections.min(this.y);
        double yMax = Collections.max(this.y);
    
        return new Envelope(new Coordinate(xMin, yMin), new Coordinate(xMax, yMax));
    }

}
