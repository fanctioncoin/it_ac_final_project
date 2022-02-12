package by.staravoyt.app.dto.convertors.models;

import org.springframework.stereotype.Component;

import by.staravoyt.app.dto.BandDto;
import by.staravoyt.app.dto.CoachDto;
import by.staravoyt.app.dto.convertors.ModelDtoConvertor;
import by.staravoyt.app.models.Band;
import by.staravoyt.app.models.Coach;


@Component
public class BandModelDtoConvertor implements ModelDtoConvertor<Band, BandDto>
{

    @Override
    public BandDto convert(Band band)
    {
        return BandDto.builder()
                       .id(band.getId())
                       .name(band.getName())
                       .coach(band.getCoach())
                       .students(band.getStudents())
                       .disciplines(band.getDisciplines())
                       .build();
    }
}
