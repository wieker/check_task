package org.example.service.impl;

import org.example.service.ClientInfoMapper;
import org.example.dts.client.LatestData;
import org.example.dts.client.RouteInformation;
import org.example.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientInfoMapperImpl implements ClientInfoMapper {
    @Override
    public RouteInformation mapRouteToClientInformation(Route route) {
        return new RouteInformation(
                        route.getFrom(),
                        route.getTo(),
                        route.getTravelDistance(),
                        route.getTravelDuration(),
                        route.getDateTime().toString());
    }

    @Override
    public LatestData mapRoutesToClientInformation(List<Route> route) {
        return new LatestData(route.stream().map(this::mapRouteToClientInformation).collect(Collectors.toList()));
    }
}
