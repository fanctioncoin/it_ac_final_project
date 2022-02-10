package by.staravoyt.app.models;


import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import by.staravoyt.app.models.auth.CredUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString(callSuper = true, exclude = "bands")
@EqualsAndHashCode(callSuper = true, exclude = "bands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Coach extends Person{
    private int salary;

    public Coach(Integer id, CredUser credUser, String name, int age, int salary) {
        super(id, credUser, name, age);
        this.salary = salary;
    }
    public Coach( Integer id, String name, int age, int salary) {
        super(id, name, age);
        this.salary = salary;
    }

    public Coach(CredUser credUser, String name, int age, int salary) {
        super(credUser, name, age);
        this.salary = salary;
    }

    @Override
    public Coach withId(Integer id) {
        setId(id);
        return this;
    }

    @Override
    public Coach withCredUser(CredUser credUser) {
        setCredUser(credUser);
        return this;
    }

    @Override
    public Coach withName(String name) {
        setName(name);
        return this;
    }

    @Override
    public Coach withAge(Integer age) {
        setAge(age);
        return this;
    }

    public Coach withSalary(Integer salary) {
        setSalary(salary);
        return this;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}
