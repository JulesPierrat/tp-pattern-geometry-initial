package org.acme.geometry;

public class GeoJSONWriter implements GeometryWriter{
    // Constructor
    public GeoJSONWriter(){

    }

    public String getName() {
        return "GeoJSON";
    }

    public String write(Geometry geometry) {
        String r = "{'type': 'FeaturesCollection', 'features': [";
            if (geometry.getType() == "Point"){
                Point point = (Point) geometry;
                r += "{'type': 'Feature', 'geometry': {'type': 'Point', 'coordinate': ["+point.getCoordinate().getX()+", "+point.getCoordinate().getY()+"]}}";
            } else if (geometry.getType() == "LineString"){
                LineString line = (LineString) geometry;
                r += "{'type': 'Feature', 'geometry': {'type': 'LineString', 'coordinate': [";
                for (int i = 0 ; i < line.getNumPoints() ; i++) {
                    r += "["+line.getPointN(i).getCoordinate().getX()+", "+line.getPointN(i).getCoordinate().getY()+"]";
                    if (i != line.getNumPoints() -1){
                        r += ",";
                    }
                }
                r += "]}";
            } else if (geometry.getType() == "GeometryCollection") {
                GeometryCollection geometryCollection = (GeometryCollection) geometry;
                for (int j = 0 ; j < geometryCollection.getNumGeometries() ; j++) {
                    if (geometryCollection.getGeometryN(j).getType() == "Point"){
                        Point point = (Point)geometryCollection.getGeometryN(j);
                        r += "{'type': 'Feature', 'geometry': {'type': 'Point', 'coordinate': ["+point.getCoordinate().getX()+", "+point.getCoordinate().getY()+"]}}";
                    } else if (geometryCollection.getGeometryN(j).getType() == "LineString"){
                        LineString line = (LineString) geometryCollection.getGeometryN(j);
                        r += "{'type': 'Feature', 'geometry': {'type': 'LineString', 'coordinate': [";
                        for (int i = 0 ; i < line.getNumPoints() ; i++) {
                            r += "["+line.getPointN(i).getCoordinate().getX()+", "+line.getPointN(i).getCoordinate().getY()+"]";
                            if (i != line.getNumPoints() -1){
                                r += ",";
                            }
                        }
                        r += "]}";
                    }
                    if (j != geometryCollection.getNumGeometries() - 1) {
                        r += ",";
                    }
                }
                r += "}";
            }
        r += "]}";
        return r;
    }

    //
    
}
