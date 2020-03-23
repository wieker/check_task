package org.example.service;

import org.example.dts.client.LatestData;
import org.example.dts.client.RouteInformation;
import org.example.model.Route;

import java.util.List;

public interface ClientInfoMapper {
    RouteInformation mapRouteToClientInformation(Route route);

    LatestData mapRoutesToClientInformation(List<Route> route);
}
