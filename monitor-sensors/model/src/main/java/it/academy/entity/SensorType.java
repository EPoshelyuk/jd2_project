package it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_SENSOR_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorType {

    @Id
    @Column(name = "ST_ID")
    @GeneratedValue(generator = "uuid-increment")
    @GenericGenerator(name = "uuid-increment", strategy = "increment")
    private Long typeId;

    @Column(name = "ST_NAME")
    private String typeName;

}
