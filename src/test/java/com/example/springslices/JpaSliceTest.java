package com.example.springslices;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = true)
public class JpaSliceTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    SpinRepository spinRepository;

    @Test
    public void testShouldRecordNewSpin() {
        Spin entity = testEntityManager.persistFlushFind(new Spin(null, new Date(), Directions.UP));
        Assertions.assertThat(entity).as("is a persistent entity").isNotNull();
        Assertions.assertThat(entity.getDirection()).as("Spin has direction").isNotNull();
        Assertions.assertThat(entity.getTimestamp()).as("Spin was recorded for real").isNotNull();
    }

    @Test
    public void testShouldFetchLast() {
        spinRepository.saveAll(Arrays.asList(
                new Spin(null, new Date(), Directions.CHARM),
                new Spin(null, new Date(), Directions.BOTTOM),
                new Spin(null, new Date(), Directions.UP)
        ));

        Spin last = spinRepository.findFirstByDirection(Directions.UP);

        Assertions.assertThat(last).as("Has an element").isNotNull();
        Assertions.assertThat(last.getId()).as("Is persisted").isNotNull();
        Assertions.assertThat(last.getDirection()).as("Has a direction").isNotNull();
    }
}
