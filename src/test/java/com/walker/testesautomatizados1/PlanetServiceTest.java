package com.walker.testesautomatizados1;

import com.walker.testesautomatizados1.domain.entity.Planet;
import com.walker.testesautomatizados1.domain.repository.PlanetRepository;
import com.walker.testesautomatizados1.domain.service.PlanetService;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

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

    @Test
    public void createPlanet_WithInvalid_Data_ThrowsException(){
        when(planetRepository.save(PlanetConstants.INVALID_PLANET)).thenThrow(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> planetService.create(PlanetConstants.INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getPlanet_ByExistingId_ReturnsPlanet() {
        when(planetRepository.findById(PlanetConstants.ID_EXISTING)).thenReturn(Optional.of(PlanetConstants.PLANET_ID_EXISTING));
        Planet planetIdExisting = planetService.findById(PlanetConstants.ID_EXISTING);

        Assertions.assertThat(planetIdExisting).isEqualTo(PlanetConstants.PLANET_ID_EXISTING);
    }

    @Test
    public void getPlanet_ByUnexistingId_ReturnException() {
        when(planetRepository.findById(PlanetConstants.ID_NO_EXISTING)).thenThrow(new EntityNotFoundException());

        Assertions.assertThatThrownBy(() -> planetService.findById(PlanetConstants.ID_NO_EXISTING)).isInstanceOf(EntityNotFoundException.class);
    }
}