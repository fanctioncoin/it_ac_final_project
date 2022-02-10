package by.staravoyt.app.models;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import by.staravoyt.app.models.auth.CredUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "adm")
public class Admin extends Person
{


    @Override
    public Admin withId(Integer id) {
        setId(id);
        return this;
    }

    @Override
    public Admin withCredUser(CredUser credUser) {
        setCredUser(credUser);
        return this;
    }

    @Override
    public Admin withName(String name) {
        setName(name);
        return this;
    }

    @Override
    public Admin withAge(Integer age) {
        setAge(age);
        return this;
    }

}

