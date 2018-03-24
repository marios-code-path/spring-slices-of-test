package com.example.springslices;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MvcSliceTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SpinRepository spinRepository;

    @Before
    public void setUp() {
        Mockito.when(spinRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Spin(null, new Date(), Directions.CHARM),
                        new Spin(null, new Date(), Directions.BOTTOM),
                        new Spin(null, new Date(), Directions.UP)
                ));
    }

    @Test
    public void testShouldReturnSpins() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/spins"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].direction").hasJsonPath())
                .andExpect(MockMvcResultMatchers.jsonPath("@.length()").value(3));
    }
}
