package by.staravoyt.app.dto;

import java.util.List;
import java.util.Set;

import by.staravoyt.app.dto.AbstractDto;
import by.staravoyt.app.models.Coach;
import by.staravoyt.app.models.Discipline;
import by.staravoyt.app.models.Student;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class BandDto extends AbstractDto
{
    private Coach coach;
    private Set<Student> students;
    private List<String> disciplines;
}
