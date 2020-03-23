package org.example.service.maps.impl;

import org.example.dts.maps.service.Point;
import org.example.dts.maps.service.Request;
import org.example.dts.maps.service.Result;
import org.example.model.Route;
import org.example.service.DateTimeProvider;
import org.example.service.maps.MapsRequestMapper;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MapsRequestMapperImpl implements MapsRequestMapper {
    @Override
    public Request mapRouteToRequest(Route route) {
        List<Point> origins = Arrays.asList(new Point(route.getFrom().getLatitude(), route.getFrom().getLongitude()));
        List<Point> destinations = Arrays.asList(new Point(route.getTo().getLatitude(), route.getTo().getLongitude()));
        return new Request(origins, destinations, "driving", route.getDateTime().toString(DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ")));
    }

    @Override
    public Route mapResponseToRoute(Route route, Result result) {
        return new Route(route.getFrom(), route.getTo(), result.getTravelDistance(), result.getTravelDuration(), route.getDateTime());
    }
}
