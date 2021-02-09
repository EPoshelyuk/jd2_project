package it.academy;

import it.academy.dto.UnitDto;

import java.util.List;

public interface UnitService {

    UnitDto getUnit(Long id);

    List<UnitDto> getAllUnit();
}
