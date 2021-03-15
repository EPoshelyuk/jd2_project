package it.academy.monitorSensorProject.service;


import it.academy.monitorSensorProject.service.dto.SensorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface SensorService {

    Page<SensorDTO> searchSensorsByParam(String param, Pageable pageable);

    void saveNewSensor(SensorDTO sensorDTO);

    SensorDTO getSensorById(String id);

    void updateSensor(String id, SensorDTO sensorDTO);

    void deleteSensor(String id);

    Page<SensorDTO> findAllSensors(Pageable pageable);

}
