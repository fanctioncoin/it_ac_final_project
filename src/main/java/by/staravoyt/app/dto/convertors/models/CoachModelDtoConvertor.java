package by.staravoyt.app.dto.convertors.models;

import org.springframework.stereotype.Component;

import by.staravoyt.app.dto.CoachDto;
import by.staravoyt.app.dto.convertors.ModelDtoConvertor;
import by.staravoyt.app.models.Coach;


@Component
public class CoachModelDtoConvertor implements ModelDtoConvertor<Coach, CoachDto>
{

    @Override
    public CoachDto convert(Coach coach)
    {
        return CoachDto.builder()
                       .id(coach.getId())
                       .credUser(coach.getCredUser())
                       .name(coach.getName())
                       .age(coach.getAge())
                       .salary(coach.getSalary())
                       .build();
    }
}
