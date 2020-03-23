package org.example.service.maps;

import org.example.dts.maps.service.Request;
import org.example.dts.maps.service.Result;
import org.example.model.Route;

public interface MapsRequestMapper {
    Request mapRouteToRequest(Route route);

    Route mapResponseToRoute(Route route, Result result);
}
