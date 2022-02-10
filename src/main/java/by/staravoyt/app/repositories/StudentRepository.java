package by.staravoyt.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import by.staravoyt.app.models.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByName(String name);

    Optional<Student> findById(Integer id);

    List<Student> findAllByBand_Id(Integer id);
}
