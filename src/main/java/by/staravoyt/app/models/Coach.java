package by.staravoyt.app.models;


import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import by.staravoyt.app.models.auth.CredUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@ToString(callSuper = true, exclude = "bands")
@EqualsAndHashCode(callSuper = true, exclude = "bands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@SuperBuilder
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
