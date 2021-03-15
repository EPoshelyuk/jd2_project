package it.academy.monitorSensorProject.repository.entity;


import it.academy.monitorSensorProject.repository.entity.enums.Type;
import it.academy.monitorSensorProject.repository.entity.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_SENSORS_SPEC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorSpec {
    @Id
    @Column(name = "SS_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "SS_MODEL")
    private String model;

    @Column(name = "SS_TYPE")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "SS_UNIT")
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(name = "SS_RF")
    private double rangeFrom;

    @Column(name = "SS_RT")
    private double rangeTo;

    @OneToMany(mappedBy = "sensorSpec",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sensor> sensors;

}
