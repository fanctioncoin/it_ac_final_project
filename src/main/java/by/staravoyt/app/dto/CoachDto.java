package by.staravoyt.app.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class CoachDto extends AbstractDto
{
    private int salary;
}
