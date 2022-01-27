package com.electronicid.readings.service;

import com.electronicid.readings.model.ReadingsDTO;

public interface StatsService {

    /**
     * Method that obtains the biggest increment between temperatures
     *
     * @param readingsDTO readingsDTO
     * @return Integer
     */
    Integer compute(ReadingsDTO readingsDTO);
}
