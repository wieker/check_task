package org.example.controller;

import org.example.dts.client.LatestData;
import org.example.model.Route;
import org.example.service.ClientInfoMapper;
import org.example.service.ProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ProcessingService processingServiceImpl;
    @Autowired
    ClientInfoMapper clientInfoMapper;

    @RequestMapping(value = "latest", method = RequestMethod.GET)
    public LatestData latest() {
        List<Route> routes = processingServiceImpl.latest();
        return clientInfoMapper.mapRoutesToClientInformation(routes);
    }

}
