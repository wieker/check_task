package org.example.dao.impl;

import org.example.model.ExecutionState;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class ExecutionStateDaoImpl implements org.example.dao.ExecutionStateDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ExecutionState latest() {
        return jdbcTemplate.query(
                "select * from execution_state",
                (rs, rowNum) ->
                        new ExecutionState(
                                new DateTime(rs.getTimestamp("datetime")),
                                rs.getInt("version")
                        )
        ).get(0);
    }

    @Override
    public void update(ExecutionState executionState) {
        if (jdbcTemplate.update(
                "update execution_state set datetime = ?, version = ? where version = ?",
                new Timestamp(executionState.getDateTime().getMillis()),
                executionState.getVersion() + 1,
                executionState.getVersion()) < 1) {
            // It seems it is completely not needed because H2 DB doesn't support optimistic locks and
            // will always throw an exception
            throw new RuntimeException("state was updated concurrently");
        }
    }
}
