package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry{
    // Atribute
    private List<GeometryListener> listeners;

    // Constructors
    protected AbstractGeometry(){
        this.listeners = new ArrayList<>();
    }
    
    public abstract Geometry clone();

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
        return visitor.getResult();
    };

    public Envelope getEnvelope(){
        EnvelopeBuilder envelope = new EnvelopeBuilder();
        this.accept(envelope);
        return envelope.build();
    }

    public void addListener(GeometryListener listener){
        this.listeners.add(listener);
    }

    protected void triggerChange(){
        for (GeometryListener listener : listeners) {
            listener.onChange(this);
        }
    };
}
