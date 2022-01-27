package com.electronicid.readings.controller;

import com.electronicid.readings.controller.impl.StatsControllerImpl;
import com.electronicid.readings.model.ReadingsDTO;
import com.electronicid.readings.service.StatsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class StatsControlerImplTest {

    @InjectMocks
    private StatsControllerImpl statsController;
    @Mock
    private StatsService statsService;
    @Mock
    private ReadingsDTO readingsDTO;

    @Test
    public void computeResponseValid() {
        when(readingsDTO.getReadings()).thenReturn(Collections.singletonList(1));
        when(statsService.compute(any())).thenReturn(0);
        ResponseEntity<Integer> res = statsController.compute(readingsDTO);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertEquals(0, res.getBody());
    }
}
