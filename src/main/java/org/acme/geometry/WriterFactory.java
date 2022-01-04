package org.acme.geometry;

public class WriterFactory {
    // Constructor
    public WriterFactory(){

    }

    // Method
    public GeometryWriter createGeometryWriter(String type){
        if (type == "WKT"){
            return new WktWriter();
        } else if (type == "GeoJSON") {
            return new GeoJSONWriter();
        } else {
            return null;
        }
    }
}
