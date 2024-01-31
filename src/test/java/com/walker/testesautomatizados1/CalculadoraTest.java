package com.walker.testesautomatizados1;

import com.walker.testesautomatizados1.Calculadora;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    public void testeAdicao() {
        Calculadora calculadora = new Calculadora();
        Assertions.assertThat(calculadora.adicao(1,1)).isEqualTo(2); // Utilizando a biblioteca AssertJ
    }
}