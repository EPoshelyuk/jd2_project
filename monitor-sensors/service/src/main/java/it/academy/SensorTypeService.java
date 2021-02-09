package it.academy;

import it.academy.dto.SensorTypeDto;

import java.util.List;

public interface SensorTypeService {

    SensorTypeDto getSensorType(Long id);

    List<SensorTypeDto> getAllSensorType();

}
