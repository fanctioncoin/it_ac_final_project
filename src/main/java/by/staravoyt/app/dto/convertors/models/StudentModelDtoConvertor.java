package by.staravoyt.app.dto.convertors.models;

import org.springframework.stereotype.Component;

import by.staravoyt.app.dto.StudentDto;
import by.staravoyt.app.dto.convertors.ModelDtoConvertor;
import by.staravoyt.app.models.Student;


@Component
public class StudentModelDtoConvertor implements ModelDtoConvertor<Student, StudentDto>
{

    @Override
    public StudentDto convert(Student student)
    {
        return StudentDto.builder()
                         .id(student.getId())
//                         .credUser(student.getCredUser())
                         .name(student.getName())
                         .age(student.getAge())
                         .band(student.getBand())
                         .marks(student.getMarks())
                         .build();
    }
}
