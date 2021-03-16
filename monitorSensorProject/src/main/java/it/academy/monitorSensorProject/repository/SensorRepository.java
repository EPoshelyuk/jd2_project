package it.academy.monitorSensorProject.repository;

import it.academy.monitorSensorProject.repository.entity.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {

    @Query("SELECT s from Sensor s where s.name like %?1%" +
            "or s.sensorSpec.model like %?1%" +
            "or CONCAT(s.sensorSpec.rangeFrom, '') like %?1%" +
            "or CONCAT(s.sensorSpec.rangeTo, '') like %?1%" +
            "or s.location like %?1%" +
            "or s.description like %?1%" +
            "or s.sensorSpec.type like %?1%" +
            "or s.sensorSpec.unit like %?1%" )
    Page<Sensor> searchSensorsByParam(String param, Pageable pageable);

}
