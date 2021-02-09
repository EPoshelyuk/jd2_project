package it.academy.impl;

import it.academy.SensorService;
import it.academy.dto.SensorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    @Override
    public SensorDto create(SensorDto entity) {
        return null;
    }

    @Override
    public SensorDto read(Long id) {
        return null;
    }

    @Override
    public List<SensorDto> readAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public SensorDto update(SensorDto entity) {
        return null;
    }
}
