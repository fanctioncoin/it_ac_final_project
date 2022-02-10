package by.staravoyt.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.staravoyt.app.dto.BandDto;
import by.staravoyt.app.dto.convertors.ModelDtoConvertor;
import by.staravoyt.app.exceptions.ApplicationException;
import by.staravoyt.app.models.Band;
import by.staravoyt.app.repositories.BandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BandService
{
    private final BandRepository bandRepository;
    private final ModelDtoConvertor<Band, BandDto> bandBandDtoModelDtoConvertor;


    public List<BandDto> findAll()
    {
        List<Band> bands = bandRepository.findAll();
        try
        {
            if (bands == null || bands.isEmpty())
            {
                throw new ApplicationException("List band is empty!!!");
            }
        } catch (ApplicationException | NullPointerException e)
        {
            log.error(e.getMessage());
            return new ArrayList<>();
        }
        return bandBandDtoModelDtoConvertor.convert(bands);
    }


    public Optional<Band> findById(Integer id)
    {
        Optional<Band> band = bandRepository.findById(id);
        return band;
    }
}

