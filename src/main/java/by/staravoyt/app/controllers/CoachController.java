package by.staravoyt.app.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.staravoyt.app.dto.CoachDto;
import by.staravoyt.app.models.Coach;
import by.staravoyt.app.services.CoachService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class CoachController
{
    private final CoachService coachService;

    @GetMapping(path = "/list-coaches")
    public ModelAndView getAll()
    {
        ModelAndView modelAndView = new ModelAndView();
        List<CoachDto> coachesDto = coachService.findAll();
        modelAndView.addObject("salary",coachService.averageSalary(coachesDto));
        modelAndView.addObject("coaches", coachesDto);
        modelAndView.addObject("coachDto",new CoachDto());
        modelAndView.setViewName("/coach/show-coaches");
        return modelAndView;
    }


    @PostMapping(value = "/update-coach")
    public String updateCoach(@RequestParam(value = "id") Integer id,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value = "age") Integer age,
                              @RequestParam(value = "salary") Integer salary)
    {
        Coach coachNew = coachService.findById(id).orElse(null);
        coachNew.setName(name);
        coachNew.setAge(age);
        coachNew.setSalary(salary);
        coachService.save(coachNew);
        return "redirect:/list-coaches";

    }

    @GetMapping(path = "/add-coach")
    public ModelAndView preparationCreateCoach(Model model)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("coachDto",new CoachDto());
        modelAndView.setViewName("/coach/add-coach");
        return modelAndView;
    }

    @PostMapping(value = "/add-coach")
    public String createCoach(@ModelAttribute(value = "coachDto") CoachDto coachDto)
    {
        coachService.create(coachDto);
        return "redirect:/list-coaches";
    }

    @PostMapping(value = "/delete-coach")
    public String deleteCoach(@RequestParam(value = "id") Integer id)
    {
        coachService.delete(id);
        return  "redirect:/list-coaches";
    }

}
