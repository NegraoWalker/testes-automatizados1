package com.walker.testesautomatizados1.domain.service;

import com.walker.testesautomatizados1.domain.entity.Planet;
import com.walker.testesautomatizados1.domain.repository.PlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    private PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet){
        return planetRepository.save(planet);
    }
}
