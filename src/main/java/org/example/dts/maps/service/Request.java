package org.example.dts.maps.service;

import java.util.ArrayList;
import java.util.List;

public class Request {
    List<Point> origins = new ArrayList<Point>();
    List<Point> destinations = new ArrayList<Point>();
    String travelMode = "";
    String startTime = "";

    public Request() {
    }

    public Request(List<Point> origins, List<Point> destinations, String travelMode, String startTime) {
        this.origins = origins;
        this.destinations = destinations;
        this.travelMode = travelMode;
        this.startTime = startTime;
    }

    public List<Point> getOrigins() {
        return origins;
    }

    public void setOrigins(List<Point> origins) {
        this.origins = origins;
    }

    public List<Point> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Point> destinations) {
        this.destinations = destinations;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
