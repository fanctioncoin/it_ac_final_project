package by.staravoyt.app.repositories.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import by.staravoyt.app.models.auth.CredUser;


public interface CredUserRepository extends JpaRepository<CredUser, Long> {

    Optional<CredUser> findByUsername(String username);
}
