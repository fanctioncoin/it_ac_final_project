package by.staravoyt.app.models.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserPrincipal implements UserDetails {
    public static final String ROLE_PREFIX = "ROLE_";
    private final CredUser credUser;
    private final Collection<SimpleGrantedAuthority> authorities;

    public UserPrincipal(CredUser credUser) {
        this.credUser = credUser;
        List<SimpleGrantedAuthority> roleList = credUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role.getName()))
                .collect(Collectors.toList());

        List<SimpleGrantedAuthority> authorityList = credUser.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());

        this.authorities = new ArrayList<>();
        this.authorities.addAll(roleList);
        this.authorities.addAll(authorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public String getUsername()
    {
        return credUser.getUsername();
    }

    @Override
    public String getPassword() {
        return credUser.getPassword();
    }

    @Override
    public boolean isEnabled() {
        return credUser.isEnabled();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
