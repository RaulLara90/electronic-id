package com.electronicid.readings.controller;

import com.electronicid.readings.model.ReadingsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "StatsController")
@RequestMapping("/v2/stats")
public interface StatsController {

    @ApiOperation(
            value = "Compute",
            nickname = "Compute",
            response = Integer.class
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            code = 200,
                            message = "Compute",
                            response = Integer.class
                    )
            }
    )
    @PostMapping(value = "/compute")
    ResponseEntity<Integer> compute(@RequestBody ReadingsDTO readingsDTO);
}
