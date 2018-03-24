package com.example.springslices;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultTest {

    @Autowired
    private SpinRepository spinRepository;

    @Test
    public void contextLoaded() {
        Assertions.assertThat(this.spinRepository).isNotNull();
    }

}
