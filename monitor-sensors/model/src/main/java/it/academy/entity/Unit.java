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
    @GeneratedValue(generator = "uuid-increment")
    @GenericGenerator(name = "uuid-increment", strategy = "increment")
    private Long unitId;

    @Column(name = "U_UNIT")
    private String unit;


}
