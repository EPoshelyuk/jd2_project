package it.academy.monitorSensorProject.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_SENSORS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @Column(name = "S_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String sensorId;

    @Column(name = "S_NAME")
    private String name;

    @Column(name = "S_LOCATION")
    private String location;

    @Column(name = "S_DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name="SS_ID")
    private SensorSpec sensorSpec;
}
