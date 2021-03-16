package it.academy.monitorSensorProject.service.converter;

import it.academy.monitorSensorProject.repository.entity.Sensor;
import it.academy.monitorSensorProject.repository.entity.SensorSpec;
import it.academy.monitorSensorProject.service.dto.SensorDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class SensorConverter {

    public Sensor fromDTO(SensorDTO sensorDTO) {

      Sensor sensor= new Sensor();
      sensor.setSensorId(sensorDTO.getSensorId());
      sensor.setName(sensorDTO.getName());
      sensor.setDescription(sensorDTO.getDescription());
      sensor.setLocation(sensorDTO.getLocation());

      SensorSpec sensorSpec= new SensorSpec();
      sensorSpec.setModel(sensorDTO.getModel());
      sensorSpec.setType(sensorDTO.getType());
      sensorSpec.setUnit(sensorDTO.getUnit());
      sensorSpec.setRangeTo(sensorDTO.getRangeTo());
      sensorSpec.setRangeFrom(sensorDTO.getRangeFrom());

      sensor.setSensorSpec(sensorSpec);
      return sensor;

    }

    public SensorDTO toDTO(Sensor sensor) {
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setSensorId(sensor.getSensorId());
        sensorDTO.setName(sensor.getName());
        sensorDTO.setModel(sensor.getSensorSpec().getModel());
        sensorDTO.setDescription(sensor.getDescription());
        sensorDTO.setLocation(sensor.getLocation());
        sensorDTO.setRangeFrom(sensor.getSensorSpec().getRangeFrom());
        sensorDTO.setRangeTo(sensor.getSensorSpec().getRangeTo());
        sensorDTO.setType(sensor.getSensorSpec().getType());
        sensorDTO.setUnit(sensor.getSensorSpec().getUnit());
        return  sensorDTO;
    }

}
