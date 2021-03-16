package it.academy.monitorSensorProject.service.dto;

import it.academy.monitorSensorProject.repository.entity.enums.Type;
import it.academy.monitorSensorProject.repository.entity.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class SensorDTO {

    private String sensorId;

    @NotBlank(message = "Please provide a name")
    @Length(max = 30, message = "Please, provide shorter(less 30 symbols) a name.")
    private String name;

    @Length(max = 40, message = "Please, provide shorter(less 40 symbols) a location.")
    private String location;

    @Length(max = 200, message = "Please, provide shorter(less 200 symbols) a description.")
    private String description;

    @NotBlank(message = "Please provide  a model")
    @Length(max = 15, message = "Please, provide shorter(less 15 symbols) a model.")
    private String model;

    private Type type;

    private Unit unit;

    private double rangeFrom;

    private double rangeTo;

}

