package org.example.dao;

import org.example.model.Route;

import java.util.List;

public interface RouteInfoDao {
    List<Route> getLatest(int count);

    void saveNew(Route route);
}
