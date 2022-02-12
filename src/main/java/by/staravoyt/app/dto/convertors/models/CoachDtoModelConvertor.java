package by.staravoyt.app.dto.convertors.models;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.stereotype.Component;

import by.staravoyt.app.dto.CoachDto;
import by.staravoyt.app.dto.convertors.DtoModelConvertor;
import by.staravoyt.app.models.Coach;
import by.staravoyt.app.models.auth.Authority;
import by.staravoyt.app.models.auth.CredUser;
import by.staravoyt.app.models.auth.Role;


@Component
public class CoachDtoModelConvertor implements DtoModelConvertor<CoachDto, Coach>
{
    @Override
    public Coach convert(final CoachDto coachDto)
    {

        return   Coach.builder()
                      .credUser(
                                 CredUser.builder()
                                  .username(coachDto.getCredUser().getUsername())
                                  .password(coachDto.getCredUser().getPassword())
                                  .enabled(true)
                                  .roles(addRoleCoach())
                                         .authorities(addAuthorityCoach())
                                         .build())
                      .name(coachDto.getName())
                      .age(coachDto.getAge())
                      .salary(coachDto.getSalary())
                      .build();
    }

    private Collection<Authority> addAuthorityCoach()
    {
        Collection<Authority> authorities =new LinkedHashSet<>();
        authorities.add(new Authority("READ_INFO"));
        return authorities;
    }

    private Collection<Role> addRoleCoach()
    {
        Collection<Role> role =new LinkedHashSet<>();
        role.add(new Role("COACH"));
        return role;
    }
}
