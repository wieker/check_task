package org.example.service;

import org.example.model.Route;

import java.util.List;

public interface ProcessingService {
    void process();

    List<Route> latest();
}
