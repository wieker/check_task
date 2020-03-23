package org.example.dts.client;


import java.util.ArrayList;
import java.util.List;

public class LatestData {
    List<RouteInformation> routes = new ArrayList<>();

    public LatestData() {
    }

    public LatestData(List<RouteInformation> routes) {
        this.routes = routes;
    }

    public List<RouteInformation> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteInformation> routes) {
        this.routes = routes;
    }
}
