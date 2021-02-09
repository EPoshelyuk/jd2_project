package it.academy;

import it.academy.dto.SensorDto;

import java.util.List;

public interface SensorService {

    SensorDto create(SensorDto entity);

    SensorDto read(Long id);

    List<SensorDto> readAll();

    void delete(Long id);

    SensorDto update(SensorDto entity);

}
