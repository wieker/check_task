package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
    @Autowired
    private ProcessingService processingServiceImpl;

    @Scheduled(fixedRate = 5000)
    public void remind() {
        processingServiceImpl.process();
    }
}
