package org.example.dao;

import org.example.SpringMain;
import org.example.model.Point;
import org.example.model.Route;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringMain.class)
public class RouteInfoDaoTest {
    @Autowired
    RouteInfoDao dao;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @After
    public void clean() {
        jdbcTemplate.update("delete from ROUTES");
    }

    @Test
    public void testDataAccess() {
        DateTime dateTime = new DateTime();

        dao.saveNew(new Route(new Point(0, 1), new Point(2, 3), 4, 5, dateTime));
        List<Route> latest = dao.getLatest(10);

        double epsilon = 0.01;
        assertEquals(1, latest.size());
        assertEquals(0, latest.get(0).getFrom().getLatitude(), epsilon);
        assertEquals(1, latest.get(0).getFrom().getLongitude(), epsilon);
        assertEquals(2, latest.get(0).getTo().getLatitude(), epsilon);
        assertEquals(3, latest.get(0).getTo().getLongitude(), epsilon);
        assertEquals(4, latest.get(0).getTravelDistance(), epsilon);
        assertEquals(5, latest.get(0).getTravelDuration(), epsilon);
        assertEquals(dateTime, latest.get(0).getDateTime());
    }

    @Test
    public void testDataAccessLimit() {
        DateTime dateTime = new DateTime();

        dao.saveNew(new Route(new Point(0, 1), new Point(2, 3), 4, 5, dateTime));
        dao.saveNew(new Route(new Point(0, 1), new Point(2, 3), 4, 5, dateTime));
        dao.saveNew(new Route(new Point(7, 1), new Point(2, 3), 4, 5, dateTime));
        List<Route> latest = dao.getLatest(2);

        double epsilon = 0.01;
        assertEquals(2, latest.size());
        assertEquals(7, latest.get(0).getFrom().getLatitude(), epsilon);
        assertEquals(1, latest.get(0).getFrom().getLongitude(), epsilon);
        assertEquals(2, latest.get(0).getTo().getLatitude(), epsilon);
        assertEquals(3, latest.get(0).getTo().getLongitude(), epsilon);
        assertEquals(4, latest.get(0).getTravelDistance(), epsilon);
        assertEquals(5, latest.get(0).getTravelDuration(), epsilon);
        assertEquals(dateTime, latest.get(0).getDateTime());
    }
}
