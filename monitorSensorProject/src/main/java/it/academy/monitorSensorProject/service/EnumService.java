package it.academy.monitorSensorProject.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnumService {
    List<String> getAllTypes() ;

    List<String> getAllUnits();

}
