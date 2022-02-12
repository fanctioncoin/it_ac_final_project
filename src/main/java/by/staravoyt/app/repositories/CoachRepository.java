package by.staravoyt.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import by.staravoyt.app.models.Coach;


public interface CoachRepository extends JpaRepository<Coach, Integer> {

    Optional<Coach> findByName(String name);

}
