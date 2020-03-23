package org.example.dts.maps.service;

import java.util.ArrayList;
import java.util.List;

public class ResourceSet {
    List<Resource> resources = new ArrayList<>();
    int estimatedTotal;

    public ResourceSet() {
    }

    public ResourceSet(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public int getEstimatedTotal() {
        return estimatedTotal;
    }

    public void setEstimatedTotal(int estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }
}
