package com.electronicid.readings.service.impl;

import com.electronicid.readings.model.ReadingsDTO;
import com.electronicid.readings.service.StatsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    /**
     * Method that obtains the biggest increment between temperatures
     *
     * @param readingsDTO readingsDTO
     * @return Integer
     */
    @Override
    public Integer compute(ReadingsDTO readingsDTO) {

        List<Integer> values = readingsDTO.getReadings();
        int response = 0;
        if (!values.isEmpty() && values.size() != 1 && values.stream().distinct().count() != 1) {
            int difInter;
            for (int i = 0; i < values.size() - 1; i++) {
                for (int j = i + 1; j < values.size(); j++) {
                    if (values.get(i) < values.get(j)) {
                        difInter = values.get(j) - values.get(i);
                        response = Math.max(difInter, response);
                    }
                }
            }
        }
        return response;
    }
}
