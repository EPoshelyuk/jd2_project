package it.academy.monitorSensorProject.service;

import it.academy.monitorSensorProject.service.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO getUserByUsername(String username);

}
