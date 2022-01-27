package com.electronicid.readings.service;

import com.electronicid.readings.model.ReadingsDTO;
import com.electronicid.readings.service.impl.StatsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class StatsServiceImplTest {

    @InjectMocks
    private StatsServiceImpl statsService;

    @Test
    public void computeEmptyList() {

        Integer res = statsService.compute(new ReadingsDTO(Collections.emptyList()));
        assertEquals(0, res);
    }

    @Test
    public void computeOneElementList() {
        Integer res = statsService.compute(new ReadingsDTO(Collections.singletonList(1)));
        assertEquals(0, res);
    }

    @Test
    public void computeAllSameElements() {
        Integer res = statsService.compute(new ReadingsDTO(Arrays.asList(1, 1, 1, 1, 1)));
        assertEquals(0, res);
    }

    @Test
    public void compute1() {
        Integer res = statsService.compute(new ReadingsDTO(Arrays.asList(1, 2, 3)));
        assertEquals(2, res);
    }

    @Test
    public void compute2() {
        Integer res = statsService.compute(new ReadingsDTO(Arrays.asList(3, 2, 1)));
        assertEquals(0, res);
    }

    @Test
    public void compute3() {
        Integer res = statsService.compute(new ReadingsDTO(Arrays.asList(10, 15, 18, 1, 8)));
        assertEquals(8, res);
    }

    @Test
    public void compute4() {
        Integer res = statsService.compute(new ReadingsDTO(Arrays.asList(10, 35, 15, 17, 1, 8, 54)));
        assertEquals(53, res);
    }
}
