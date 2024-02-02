package com.walker.testesautomatizados1;

import com.walker.testesautomatizados1.domain.entity.Planet;

public class PlanetConstants {
    public static final Planet PLANET = new Planet("name","climate","terrain");
    public static final Planet INVALID_PLANET = new Planet("","","");
    public static final Long ID_EXISTING = 1L;
    public static final Planet PLANET_ID_EXISTING = new Planet("nameExample","climateExample","terrainExample");
    public static final  Long ID_NO_EXISTING = 2L;
}
