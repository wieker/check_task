package org.example.dao.impl;

import org.example.dao.RouteInfoDao;
import org.example.model.Point;
import org.example.model.Route;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class RouteInfoDaoImpl implements RouteInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Route> getLatest(int count) {
        return jdbcTemplate.query(
                "select * from ROUTES order by id desc limit ?",
                new Object[]{ count },
                (rs, rowNum) ->
                        new Route(
                                new Point(rs.getDouble("from_lat"), rs.getDouble("from_lon")),
                                new Point(rs.getDouble("to_lat"), rs.getDouble("to_lon")),
                                rs.getDouble("distance"),
                                rs.getDouble("duration"),
                                new DateTime(rs.getTimestamp("datetime"))
                        )
        );
    }

    @Override
    public void saveNew(Route route) {
        jdbcTemplate.update(
                "insert into ROUTES (from_lat, from_lon, to_lat, to_lon, distance, duration, datetime) values(?,?,?,?,?,?,?)",
                route.getFrom().getLatitude(), route.getFrom().getLongitude(),
                route.getTo().getLatitude(), route.getTo().getLongitude(),
                route.getTravelDistance(), route.getTravelDuration(),
                new Timestamp(route.getDateTime().getMillis())
        );
    }
}
