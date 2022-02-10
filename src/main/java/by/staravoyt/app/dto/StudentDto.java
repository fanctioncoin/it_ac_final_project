package by.staravoyt.app.dto;

import java.util.List;

import by.staravoyt.app.models.Band;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class StudentDto extends AbstractDto
{
 private Band band;
 private List<String> marks;

}
