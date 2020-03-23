package org.example.dts.maps.service;

public class Result {
    double travelDistance;
    double travelDuration;

    public Result() {
    }

    public Result(double travelDistance, double travelDuration) {
        this.travelDistance = travelDistance;
        this.travelDuration = travelDuration;
    }

    public double getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(double travelDistance) {
        this.travelDistance = travelDistance;
    }

    public double getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(double travelDuration) {
        this.travelDuration = travelDuration;
    }
}
