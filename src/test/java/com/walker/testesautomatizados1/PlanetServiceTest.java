package com.walker.testesautomatizados1;

import com.walker.testesautomatizados1.domain.entity.Planet;
import com.walker.testesautomatizados1.domain.repository.PlanetRepository;
import com.walker.testesautomatizados1.domain.service.PlanetService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@SpringBootTest(classes = PlanetService.class)
@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {
//    @Autowired
    @InjectMocks
    private PlanetService planetService;

//    @MockBean
    @Mock
    private PlanetRepository planetRepository;


    @Test
    public void createPlanet_WithValidData_ReturnsPlanet() {
        when(planetRepository.save(PlanetConstants.PLANET)).thenReturn(PlanetConstants.PLANET);

        Planet planetCreateTest = planetService.create(PlanetConstants.PLANET);
        Assertions.assertThat(planetCreateTest).isEqualTo(PlanetConstants.PLANET);
    }
}