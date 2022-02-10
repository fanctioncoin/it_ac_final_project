package by.staravoyt.app.dto;

import by.staravoyt.app.models.auth.CredUser;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class AbstractDto
{
    protected Integer id;
    protected CredUser credUser;
    protected String name;
    protected int age;
}
