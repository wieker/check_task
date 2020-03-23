package org.example.dts.client;

import org.example.model.Point;

public class RouteInformation {
    Point from;
    Point to;
    double travelDistance;
    double travelDuration;
    String dateTime;

    public RouteInformation() {
    }

    public RouteInformation(Point from, Point to, double travelDistance, double travelDuration, String dateTime) {
        this.from = from;
        this.to = to;
        this.travelDistance = travelDistance;
        this.travelDuration = travelDuration;
        this.dateTime = dateTime;
    }

    public Point getFrom() {
        return from;
    }

    public void setFrom(Point from) {
        this.from = from;
    }

    public Point getTo() {
        return to;
    }

    public void setTo(Point to) {
        this.to = to;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
