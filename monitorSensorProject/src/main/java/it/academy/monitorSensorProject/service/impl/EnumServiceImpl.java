package it.academy.monitorSensorProject.service.impl;


import it.academy.monitorSensorProject.repository.entity.enums.Type;
import it.academy.monitorSensorProject.repository.entity.enums.Unit;
import it.academy.monitorSensorProject.service.EnumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EnumServiceImpl implements EnumService {
    @Override
    public List<String> getAllTypes() {
        List<String> allTypes;
        return allTypes = Stream.of(Type.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllUnits() {
        List<String> allUnits;
        return allUnits = Stream.of(Unit.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
