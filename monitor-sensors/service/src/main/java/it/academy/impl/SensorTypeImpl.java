package it.academy.impl;

import it.academy.SensorTypeService;
import it.academy.dto.SensorTypeDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorTypeImpl implements SensorTypeService {
    @Override
    public SensorTypeDto getSensorType(Long id) {
        return null;
    }

    @Override
    public List<SensorTypeDto> getAllSensorType() {
        return null;
    }
}
