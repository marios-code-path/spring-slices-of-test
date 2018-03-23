package com.example.springslices;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = true)
public class JPASliceTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void testShouldRecordNewSpin() {
        Spin entity = testEntityManager.persistFlushFind(new Spin(
                null, new Date(System.currentTimeMillis()), Directions.UP
        ));

        Assertions.assertThat(entity).as("is a living entity").isNotNull();
        Assertions.assertThat(entity.getDirection()).as("Spin has direction").isNotNull();
        Assertions.assertThat(entity.getTimestamp()).as("Spin was recorded for real").isNotNull();
    }

}
