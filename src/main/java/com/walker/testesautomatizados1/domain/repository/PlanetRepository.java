package com.walker.testesautomatizados1.domain.repository;

import com.walker.testesautomatizados1.domain.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
