package it.academy.monitorSensorProject.repository;


import it.academy.monitorSensorProject.repository.entity.SensorSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorSpecRepository extends JpaRepository<SensorSpec, String> {
}
