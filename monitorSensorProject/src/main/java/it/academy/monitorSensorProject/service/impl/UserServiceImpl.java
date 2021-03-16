package it.academy.monitorSensorProject.service.impl;

import it.academy.monitorSensorProject.repository.UserRepository;
import it.academy.monitorSensorProject.service.UserService;
import it.academy.monitorSensorProject.service.converter.UserConverter;
import it.academy.monitorSensorProject.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter converter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    public UserDTO getUserByUsername(String username) {
        return converter.toDTO(userRepository.findByUsername(username));
    }

}
