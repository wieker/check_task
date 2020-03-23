package org.example.service.maps.impl;

import org.example.dts.maps.service.Request;
import org.example.dts.maps.service.Response;
import org.example.dts.maps.service.Result;
import org.example.model.Route;
import org.example.service.maps.MapsClientService;
import org.example.service.maps.MapsRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapsClientServiceImpl implements MapsClientService {
    @Value("${request.key}")
    private String requestKey;
    @Value("${request.url}")
    private String requestUrl;
    @Autowired
    private MapsRequestMapper mapsRequestMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Override public Route getRouteInformation(Route route) {
        Request request = mapsRequestMapper.mapRouteToRequest(route);
        String url = requestUrl + requestKey;
        ResponseEntity<Response> forEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(request), Response.class);
        Response body = forEntity.getBody();
        Result result = body.getResourceSets().get(0).getResources().get(0).getResults().get(0);
        return mapsRequestMapper.mapResponseToRoute(route, result);
    }

}
