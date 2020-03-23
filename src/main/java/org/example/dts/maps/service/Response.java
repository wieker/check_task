package org.example.dts.maps.service;

import java.util.ArrayList;
import java.util.List;

public class Response {
    int statusCode;
    List<ResourceSet> resourceSets = new ArrayList<>();

    public Response() {
    }

    public Response(int statusCode, List<ResourceSet> resourceSets) {
        this.statusCode = statusCode;
        this.resourceSets = resourceSets;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<ResourceSet> getResourceSets() {
        return resourceSets;
    }

    public void setResourceSets(List<ResourceSet> resourceSets) {
        this.resourceSets = resourceSets;
    }
}
