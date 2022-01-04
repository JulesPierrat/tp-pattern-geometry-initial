package org.acme.geometry;

public class Point extends AbstractGeometry {
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

    // Clone
    public Point clone(){
        return new Point(this.coordinate);
    }

    // Method
    public String getType(){
        return "Point";
    }

    public boolean isEmpty(){
        return this.coordinate.isEmpty();
    }

    public void translate(double dx, double dy){
        if (this.coordinate.isEmpty()) {
            this.coordinate = new Coordinate(dx, dy);
        } else {
            this.coordinate = new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
        }
        triggerChange();
    }

    public Envelope getEnvelope(){
        if (! isEmpty()){
            return new Envelope(this.coordinate, this.coordinate);
        } else {
            return new Envelope();
        }
    }
    
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
