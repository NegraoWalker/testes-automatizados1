package com.walker.testesautomatizados1.domain.service;

import com.walker.testesautomatizados1.domain.entity.Planet;
import com.walker.testesautomatizados1.domain.repository.PlanetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanetService {
    private PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet){
        return planetRepository.save(planet);
    }
    public Planet findById(Long id){
        return planetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Planeta com Id '%s' não encontrado!",id)));
    }
}
