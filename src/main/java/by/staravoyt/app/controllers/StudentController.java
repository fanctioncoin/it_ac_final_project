package by.staravoyt.app.controllers;


import java.security.Principal;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.staravoyt.app.models.Band;
import by.staravoyt.app.models.Coach;
import by.staravoyt.app.models.Student;
import by.staravoyt.app.models.auth.Authority;
import by.staravoyt.app.models.auth.CredUser;
import by.staravoyt.app.models.auth.Role;
import by.staravoyt.app.services.CoachService;
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


//    @PostMapping(value = "/update-coach")
//    public String updateCoach(@RequestParam(value = "id") Integer id,
//                              @RequestParam(value = "name") String name,
//                              @RequestParam(value = "age") Integer age,
//                              @RequestParam(value = "salary") Integer salary,
//                              Model model)
//    {
//        Coach coachNew = coachService.findById(id).orElse(null);
//        coachNew.setName(name);
//        coachNew.setAge(age);
//        coachNew.setSalary(salary);
//        coachService.save(coachNew);
////        model.addAttribute("greeting", greeting);
//        return "redirect:/list-coaches";
//
//    }
//
//    @PostMapping(value = "/add-coach")
//    public String createCoach(@RequestParam(value = "username") String username,
//                              @RequestParam(value = "password") String password,
//                              @RequestParam(value = "name") String name,
//                              @RequestParam(value = "age") Integer age,
//                              @RequestParam(value = "salary") Integer salary,
//                              Model model)
//    {
//        Coach coach = new Coach();
//        CredUser credUser = new CredUser();
//        credUser.setUsername(username);
//        credUser.setPassword(password);
//        credUser.setEnabled(true);
//        Collection<Role> role =new LinkedHashSet<>();
//        role.add(new Role("COACH"));
//        credUser.setRoles(role);
//        Collection<Authority> authorities =new LinkedHashSet<>();
//        authorities.add(new Authority("READ_INFO"));
//        credUser.setAuthorities(authorities);
//        coach.setCredUser(credUser);
//        coach.setName(name);
//        coach.setAge(age);
//        coach.setSalary(salary);
//
//        coachService.save(coach);
//
//        return "redirect:/list-coaches";
//    }
//    @PostMapping(value = "/delete-coach")
//    public String deleteCoach(@RequestParam(value = "id") Integer id)
//    {
//        coachService.delete(id);
//        return "redirect:/list-coaches";
//    }
}
