package org.example.dao;

import org.example.model.ExecutionState;

public interface ExecutionStateDao {
    ExecutionState latest();

    void update(ExecutionState executionState);
}
