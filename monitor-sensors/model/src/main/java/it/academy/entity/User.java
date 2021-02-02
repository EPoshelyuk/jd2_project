package it.academy.entity;


import it.academy.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String UserId;

    @Column(name = "USER_LOGIN")
    private String login;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
