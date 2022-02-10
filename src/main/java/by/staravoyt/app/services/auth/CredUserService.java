package by.staravoyt.app.services.auth;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.staravoyt.app.models.auth.CredUser;
import by.staravoyt.app.models.auth.UserPrincipal;
import by.staravoyt.app.repositories.auth.CredUserRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CredUserService implements UserDetailsService {
    private final CredUserRepository credUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CredUser> userOptional = credUserRepository.findByUsername(username);
        CredUser user = userOptional.orElseThrow(() -> {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        });
        return new UserPrincipal(user);
    }
}
