package by.staravoyt.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import by.staravoyt.app.dto.StudentDto;
import by.staravoyt.app.dto.convertors.ModelDtoConvertor;
import by.staravoyt.app.exceptions.ApplicationException;
import by.staravoyt.app.models.Band;
import by.staravoyt.app.models.Coach;
import by.staravoyt.app.models.Student;
import by.staravoyt.app.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService
{
    private final StudentRepository studentRepository;
    private final ModelDtoConvertor<Student, StudentDto> studentDtoModelDtoConvertor;

    public List<StudentDto> findAll()
    {
        List<Student> students = studentRepository.findAll();
        try
        {
            if (students == null || students.isEmpty())
            {
                throw new ApplicationException("List students is empty!!!");
            }
        } catch (ApplicationException | NullPointerException e)
        {
            log.error(e.getMessage());
            return new ArrayList<>();
        }
        return studentDtoModelDtoConvertor.convert(students);
    }


    public List<StudentDto> findAllByBand_Id(Integer id)
    {
        return studentDtoModelDtoConvertor.convert(studentRepository.findAllByBand_Id(id));
    }


    public Optional<Student> findById(Integer id)
    {
        Optional<Student> student= studentRepository.findById(id);
        return student;
    }

    public Student save(Student student)
    {
        return studentRepository.save(student);
    }

    public void delete(Student student)
    {
        studentRepository.deleteById(student.getId());
    }
}
