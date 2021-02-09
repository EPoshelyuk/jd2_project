package it.academy.dto;


import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class SensorDto {

    private String name;

    private String model;

    private int rangeFrom;

    private int rangeTo;

    private String location;

    private String description;

    private SensorTypeDto type;

    private UnitDto unit;

}
