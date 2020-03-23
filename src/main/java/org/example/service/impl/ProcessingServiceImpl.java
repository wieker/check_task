package org.example.service.impl;

import org.example.dao.ExecutionStateDao;
import org.example.dao.RouteInfoDao;
import org.example.model.ExecutionState;
import org.example.model.Point;
import org.example.model.Route;
import org.example.service.DateTimeProvider;
import org.example.service.ProcessingService;
import org.example.service.maps.MapsClientService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcessingServiceImpl implements ProcessingService {
    @Value("${from.lat}")
    private Double fromLatitude;
    @Value("${from.lon}")
    private Double fromLongitude;
    @Value("${to.lat}")
    private Double toLatitude;
    @Value("${to.lon}")
    private Double toLongitude;
    @Value("${latest.count}")
    private Integer count;
    @Value("${step.minutes}")
    private Integer step;
    @Autowired
    private MapsClientService mapsClientServiceImpl;
    @Autowired
    private RouteInfoDao routeInfoDao;
    @Autowired
    private DateTimeProvider dateTimeProvider;
    @Autowired
    private ExecutionStateDao executionStateDao;

    @Override
    @Transactional
    public void process() {
        Route requestedRoute = new Route(new Point(fromLatitude, fromLongitude), new Point(toLatitude, toLongitude));
        ExecutionState executionState = executionStateDao.latest();
        DateTime timeToProcess = executionState.getDateTime();
        DateTime now = dateTimeProvider.now();
        timeToProcess = timeToProcess == null || timeToProcess.plusMinutes(step).isBefore(now)
                || timeToProcess.isAfter(now.plusDays(1)) ? now : timeToProcess.plusMinutes(step);
        requestedRoute.setDateTime(timeToProcess);
        Route route = mapsClientServiceImpl.getRouteInformation(requestedRoute);
        routeInfoDao.saveNew(route);
        executionState.setDateTime(timeToProcess);
        executionStateDao.update(executionState);
    }

    @Override
    public List<Route> latest() {
        return routeInfoDao.getLatest(count);
    }
}
