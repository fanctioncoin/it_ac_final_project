package by.staravoyt.app.controllers;


import java.security.Principal;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.staravoyt.app.models.Band;
import by.staravoyt.app.models.Coach;
import by.staravoyt.app.models.auth.Authority;
import by.staravoyt.app.models.auth.CredUser;
import by.staravoyt.app.models.auth.Role;
import by.staravoyt.app.services.BandService;
import by.staravoyt.app.services.CoachService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class BandController
{
    private final BandService bandService;

    @GetMapping(path = "/list-band")
    public ModelAndView getAll(Principal principal)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bands", bandService.findAll());
        modelAndView.setViewName("/student/show-band");
        return modelAndView;
    }

    @PostMapping(value = "/choose-band")
    public String chooseBand (@RequestParam(value = "id") Integer id,
                              RedirectAttributes redirectAttributes)
    {
        Band band = bandService.findById(id).orElse(null);
        if(band==null){
            log.error("Band not found with id {}",id);
            return "redirect:/list-band";
        }
        redirectAttributes.addFlashAttribute("band", band);
        return "redirect:/list-students";
    }
}
