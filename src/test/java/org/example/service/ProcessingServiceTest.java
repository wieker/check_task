package org.example.service;

import org.example.dao.ExecutionStateDao;
import org.example.dao.RouteInfoDao;
import org.example.model.ExecutionState;
import org.example.model.Route;
import org.example.service.impl.ProcessingServiceImpl;
import org.example.service.maps.MapsClientService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProcessingServiceTest {
    @Mock
    private MapsClientService mapsClientServiceImpl;
    @Mock
    private RouteInfoDao routeInfoDao;
    @Mock
    private DateTimeProvider dateTimeProvider;
    @Mock
    private ExecutionStateDao executionStateDao;

    @InjectMocks
    ProcessingServiceImpl processingService;

    @Before
    public void initProperties() {
        ReflectionTestUtils.setField(processingService, "fromLatitude", 9.0);
        ReflectionTestUtils.setField(processingService, "fromLongitude", 0.0);
        ReflectionTestUtils.setField(processingService, "toLatitude", 1.0);
        ReflectionTestUtils.setField(processingService, "toLongitude", 1.0);
        ReflectionTestUtils.setField(processingService, "count", 2);
        ReflectionTestUtils.setField(processingService, "step", 10);
    }

    @Test
    public void checkProcessingFromColdState() {
        DateTime dateTime = new DateTime();
        ExecutionState executionState = mock(ExecutionState.class);
        when(executionState.getDateTime()).thenReturn(dateTime.minusMinutes(20));
        when(dateTimeProvider.now()).thenReturn(dateTime);
        when(executionStateDao.latest()).thenReturn(executionState);
        ArgumentCaptor<Route> routeArgumentCaptor = ArgumentCaptor.forClass(Route.class);
        Route newRoute = new Route();
        when(mapsClientServiceImpl.getRouteInformation(routeArgumentCaptor.capture())).thenReturn(newRoute);

        processingService.process();

        verify(routeInfoDao).saveNew(newRoute);
        verify(executionState).setDateTime(dateTime);
        verify(executionStateDao).update(executionState);
        assertEquals(9, routeArgumentCaptor.getValue().getFrom().getLatitude(), 0.01);
    }
}
