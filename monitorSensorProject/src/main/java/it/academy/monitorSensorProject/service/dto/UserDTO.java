package it.academy.monitorSensorProject.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO {

    private String id;

    private String username;

    private String password;

    private String Role;

    private boolean enabled;

}
