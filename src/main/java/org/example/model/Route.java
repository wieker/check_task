package org.example.model;

import org.joda.time.DateTime;

public class Route {
    Point from;
    Point to;
    double travelDistance;
    double travelDuration;
    DateTime dateTime;

    public Route() {
    }

    public Route(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public Route(Point from, Point to, double travelDistance, double travelDuration, DateTime dateTime) {
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

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
