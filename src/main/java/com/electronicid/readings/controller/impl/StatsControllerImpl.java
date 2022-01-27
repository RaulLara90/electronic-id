package com.electronicid.readings.controller.impl;

import com.electronicid.readings.controller.StatsController;
import com.electronicid.readings.model.ReadingsDTO;
import com.electronicid.readings.service.StatsService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"Stats Controller"})
public class StatsControllerImpl implements StatsController {

    private StatsService statsService;

    /**
     * Constructor StatsControllerImpl
     *
     * @param statsService statsService
     */
    public StatsControllerImpl(StatsService statsService) {
        this.statsService = statsService;
    }

    @Override
    public ResponseEntity<Integer> compute(ReadingsDTO readingsDTO) {
        return new ResponseEntity<>(statsService.compute(readingsDTO), HttpStatus.OK);
    }
}
