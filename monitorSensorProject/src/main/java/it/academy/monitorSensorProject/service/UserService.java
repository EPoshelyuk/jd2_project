package it.academy.monitorSensorProject.service;


import it.academy.monitorSensorProject.service.dto.UserDTO;

public interface UserService {

    UserDTO getUserByUsername(String username);
}
