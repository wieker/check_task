package org.example.model;

import org.joda.time.DateTime;

public class ExecutionState {
    DateTime dateTime;
    // It seems version is completely not needed because H2 DB doesn't support optimistic locks and
    // will always throw an exception after the row was updated concurrently
    Integer version;

    public ExecutionState() {
    }

    public ExecutionState(DateTime dateTime, Integer version) {
        this.dateTime = dateTime;
        this.version = version;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
