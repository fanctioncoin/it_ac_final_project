package by.staravoyt.app.models;

// Наша группа студентов

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString(callSuper = true,exclude = "students")
@EqualsAndHashCode(callSuper = true,exclude = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Band extends EntityModel
{

    private String name;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "id_coach")
    private Coach coach;

    @OneToMany(mappedBy = "band", cascade =  {CascadeType.REFRESH,CascadeType.REMOVE})
    private Set<Student> students;

    @ElementCollection
    @CollectionTable(name = "discipline", joinColumns = @JoinColumn(name = "band_id"))
    @Column(name = "name")
    private List<String> disciplines;

    {
        students = new HashSet<>();
        disciplines = new ArrayList<>();
    }

    public Band(String name, Coach coach, List<String> disciplines) {
        this.name = name;
        this.coach = coach;
        this.disciplines = disciplines;
    }

    @Override
    public Band withId(Integer id) {
        setId(id);
        return this;
    }


    public Band withName(String name) {
        setName(name);
        return this;
    }

    public Band withCoach(Coach coach) {
        setCoach(coach);
        return this;
    }

    public Band withStudents(Set<Student> students) {
        setStudents(students);
        return this;
    }

    public Band withDisciplines(List<String> disciplines) {
        setDisciplines(disciplines);
        return this;
    }
}
