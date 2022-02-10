package by.staravoyt.app.dto.convertors.models;

import org.springframework.stereotype.Component;

import by.staravoyt.app.dto.CoachDto;
import by.staravoyt.app.dto.convertors.DtoModelConvertor;
import by.staravoyt.app.models.Coach;


@Component
public class CoachDtoModelConvertor implements DtoModelConvertor<CoachDto, Coach>
{
    @Override
    public Coach convert(final CoachDto coachDto)
    {
        return null;
    }
}
