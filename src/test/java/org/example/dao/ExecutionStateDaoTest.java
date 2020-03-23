package org.example.dao;

import org.example.SpringMain;
import org.example.model.ExecutionState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= SpringMain.class)
public class ExecutionStateDaoTest {
    @Autowired
    ExecutionStateDao executionStateDao;

    @Test
    public void testConcurrentModification() {
        ExecutionState latest = executionStateDao.latest();
        executionStateDao.update(latest);
        try {
            executionStateDao.update(latest);
        } catch (RuntimeException e) {
            assertEquals("state was updated concurrently", e.getMessage());
        }
    }
}
