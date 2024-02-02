package com.walker.testesautomatizados1.web;

import com.walker.testesautomatizados1.domain.entity.Planet;
import com.walker.testesautomatizados1.domain.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;



    @PostMapping
    public ResponseEntity<Planet> createPlanet(@RequestBody Planet planet){
        Planet planetCreated = planetService.create(planet);
        return ResponseEntity.status(HttpStatus.CREATED).body(planetCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable Long id){
        Planet planetFind = planetService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(planetFind);
    }
}
