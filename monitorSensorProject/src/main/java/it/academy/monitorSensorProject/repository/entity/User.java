package it.academy.monitorSensorProject.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "T_USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "U_ID")
    private String id;

    @Column(name = "U_USERNAME")
    private String username;

    @Column(name = "U_PASSWORD")
    private String password;

    @Column(name = "U_ROLE")
    private String Role;

    @Column(name = "U_ENABLED")
    private boolean enabled;


}
