package by.staravoyt.app.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import by.staravoyt.app.models.auth.CredUser;
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
@Entity
public class Student extends Person {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_band")
    public Band band;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @CollectionTable(name = "marks", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "mark")
    private List<String> marks;

    {
        marks = new ArrayList<>();
    }

    public Student(Integer id, CredUser credUser, String name, int age, Band band, List<String> marks) {
        super(id, credUser, name, age);
        this.marks = marks;
    }

    public  Student(CredUser credUser, String name, int age, Band band, List<String> marks) {
    }


}
