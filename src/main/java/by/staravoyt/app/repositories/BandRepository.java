package by.staravoyt.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import by.staravoyt.app.models.Band;


public interface BandRepository extends JpaRepository<Band , Integer> {

    Optional<Band> findByName(String name);

}
