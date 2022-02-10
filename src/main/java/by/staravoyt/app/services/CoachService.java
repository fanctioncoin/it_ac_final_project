package by.staravoyt.app.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import by.staravoyt.app.dto.CoachDto;
import by.staravoyt.app.dto.convertors.ModelDtoConvertor;
import by.staravoyt.app.exceptions.ApplicationException;
import by.staravoyt.app.models.Coach;
import by.staravoyt.app.repositories.CoachRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CoachService
{
    private final CoachRepository coachRepository;
    private final ModelDtoConvertor<Coach, CoachDto> coachCoachDtoModelDtoConvertor;

    public List<CoachDto> findAll()
    {
        List<Coach> coaches = coachRepository.findAll();
        try
        {
            if (coaches == null || coaches.isEmpty())
            {
                throw new ApplicationException("List coaches is empty!!!");
            }
        } catch (ApplicationException | NullPointerException e)
        {
            log.error(e.getMessage());
            return new ArrayList<>();
        }
        return coachCoachDtoModelDtoConvertor.convert(coaches);
    }


    public Optional<Coach> findById(Integer id)
    {
        Optional<Coach> coach = coachRepository.findById(id);
        return coach;
    }

    public Coach save(Coach coach)
    {
        return coachRepository.save(coach);
    }

    public void delete(Integer id)
    {
        coachRepository.deleteById(id);
    }

    public BigDecimal averageSalary(List<CoachDto> coachesDto)
    {
        List<Integer> salaries = coachesDto.stream()
                                           .map(CoachDto::getSalary)
                                           .collect(Collectors.toList());
        return average(salaries).setScale(2, RoundingMode.HALF_UP);
    }
//
    private BigDecimal average(final List<Integer> salaries)
    {
        double average = salaries.stream()
                                 .mapToInt(i -> i)
                                 .average()
                                 .orElse(0.0);
        return new BigDecimal(average);
    }
}
