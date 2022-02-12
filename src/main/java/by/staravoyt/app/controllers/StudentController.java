package by.staravoyt.app.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.staravoyt.app.models.Band;
import by.staravoyt.app.models.Student;
import by.staravoyt.app.services.StudentService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class StudentController
{
    private final StudentService studentService;

    @GetMapping(path = "/list-students")
    public ModelAndView getAll(@ModelAttribute("band") final Band band)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.findAllByBand_Id(band.getId()));
        modelAndView.setViewName("/student/show-students");
        return modelAndView;
    }

    @PostMapping(path = "/get-student")
    public ModelAndView getStudent(@RequestParam(value = "id") final Integer id,
                                   @RequestParam(value ="count") final Integer count
    )
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", studentService.findById(id));
        modelAndView.addObject("count",count);
        modelAndView.setViewName("/student/update-student");
        return modelAndView;
    }

    @PostMapping(path = "/refresh-student")
    public String refreshStudent(@RequestParam(value = "id") final Integer id,
                                       @RequestParam(value ="grade") final String grade,
                                       @RequestParam(value ="count") final Integer count
    )
    {
        Student student = studentService.findById(id).orElse(null);
        List<String> marks =student.getMarks();
        marks.set(count,grade);
        student.setMarks(marks);
        studentService.save(student);
        return "redirect:/list-band";
    }
}
