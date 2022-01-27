package com.electronicid.readings.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingsDTO implements Serializable {

    private static final long serialVersionUID = 1626435577330931819L;
    private List<Integer> readings;
}
