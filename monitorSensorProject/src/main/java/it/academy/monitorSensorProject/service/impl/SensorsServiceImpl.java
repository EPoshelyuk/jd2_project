package it.academy.monitorSensorProject.service.impl;

import it.academy.monitorSensorProject.repository.SensorRepository;
import it.academy.monitorSensorProject.repository.entity.Sensor;
import it.academy.monitorSensorProject.repository.entity.SensorSpec;
import it.academy.monitorSensorProject.service.SensorService;
import it.academy.monitorSensorProject.service.converter.SensorConverter;
import it.academy.monitorSensorProject.service.dto.SensorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SensorsServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final SensorConverter converter;

    @Autowired
    public SensorsServiceImpl(SensorRepository sensorRepository, SensorConverter converter) {
        this.sensorRepository = sensorRepository;
        this.converter = converter;
    }


    @Override
    public Page<SensorDTO> searchSensorsByParam(String param, Pageable pageable) {
        return sensorRepository.searchSensorsByParam(param, pageable).map(sensor -> converter.toDTO(sensor));
    }


    @Override
    public void saveNewSensor(SensorDTO sensorDTO) {
        sensorRepository.save(converter.fromDTO(sensorDTO));
    }

    @Override
    public SensorDTO getSensorById(String id) {
        return converter.toDTO(sensorRepository.getOne(id));

    }

    @Override
    public void updateSensor(String id, SensorDTO sensorDTO) {

        Sensor sensor = sensorRepository.getOne(id);

        SensorSpec sensorSpec=sensor.getSensorSpec();

        sensor.setName(sensorDTO.getName());
        sensor.setDescription(sensorDTO.getDescription());
        sensor.setLocation(sensorDTO.getLocation());

        sensorSpec.setModel(sensorDTO.getModel());
        sensorSpec.setUnit(sensorDTO.getUnit());
        sensorSpec.setType(sensorDTO.getType());
        sensorSpec.setRangeTo(sensorDTO.getRangeTo());
        sensorSpec.setRangeFrom(sensorDTO.getRangeFrom());

        sensor.setSensorSpec(sensorSpec);

        sensorRepository.save(sensor);
    }

    @Override
    public void deleteSensor(String id) {
        sensorRepository.deleteById(id);
    }


    public Page<SensorDTO> findAllSensors(Pageable pageable) {
        return sensorRepository.findAll(pageable).map(sensor -> converter.toDTO(sensor));
    }


}

