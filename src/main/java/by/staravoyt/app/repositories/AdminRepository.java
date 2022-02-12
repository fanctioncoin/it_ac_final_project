package by.staravoyt.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import by.staravoyt.app.models.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByName(String name);
}
