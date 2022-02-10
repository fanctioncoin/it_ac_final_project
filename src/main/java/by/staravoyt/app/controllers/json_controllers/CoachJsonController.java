package by.staravoyt.app.controllers.json_controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.staravoyt.app.dto.CoachDto;
import by.staravoyt.app.models.Coach;
import by.staravoyt.app.services.CoachService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(path = "/api/coach", produces = "application/json")
@RequiredArgsConstructor
@Slf4j
public class CoachJsonController
{
    @Autowired
    private final CoachService coachService;

    @GetMapping
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<CoachDto> getAll(Principal principal) {
        return coachService.findAll();
    }

    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Coach> createEmployee(@RequestBody Coach coach) {
        return ResponseEntity.ok(coachService.save(coach));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coach> deleteDepartment(@PathVariable int id) {
        Optional<Coach> coach = coachService.findById(id);
        if (coach.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        coachService.delete(id);
        return ResponseEntity.ok(coach.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id,
                                            @RequestBody Coach newCoach)
    {
        if (newCoach != null && id != newCoach.getId())
        {
            return ResponseEntity
                    .badRequest()
                    .body("Employee id must be equal with id in path: " + id + " != " + newCoach.getId());
        }
        return ResponseEntity.ok((getCoach(id, newCoach)).orElse(null));
    }

    private Optional<Coach> getCoach(final int id, final Coach newCoach)
    {
        return coachService.findById(id)
                           .map(coach ->
                           {
                               coach.setName(newCoach.getName());
                               coach.setAge(newCoach.getAge());
                               coach.setSalary(newCoach.getSalary());
                               return coachService.save(coach);
                           });
    }
}

