package by.staravoyt.app.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Entity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Entity withId(Integer id) {
        setId(id);
        return this;
    }

}
