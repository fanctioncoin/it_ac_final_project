package by.staravoyt.app.dto;

import by.staravoyt.app.models.auth.CredUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class AbstractDto
{
    protected Integer id;
    protected CredUser credUser;
    protected String name;
    protected int age;
}
