package it.academy.monitorSensorProject.repository;

import it.academy.monitorSensorProject.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);
}
