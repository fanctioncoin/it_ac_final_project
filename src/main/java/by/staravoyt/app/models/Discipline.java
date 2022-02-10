package by.staravoyt.app.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@javax.persistence.Entity
public class Discipline extends EntityModel
{

    private String name;

    @Override
    public Discipline withId(Integer id) {
        setId(id);
        return this;
    }

    public Discipline withName(String name) {
        setName(name);
        return this;
    }
}
