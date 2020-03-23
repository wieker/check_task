package org.example.dts.maps.service;

import java.util.ArrayList;
import java.util.List;

public class Resource {
    List<Result> results = new ArrayList<>();

    public Resource() {
    }

    public Resource(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
