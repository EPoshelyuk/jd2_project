package it.academy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_UNIT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit {

    @Id
    @Column(name = "U_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String unitId;

    @Column(name = "U_UNIT")
    private String unit;


}
