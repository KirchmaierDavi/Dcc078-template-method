package com.templatemethod.demo2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SindicatoTemplateTest {

    @Test
    void deveCalcularAumentoParaSalarioBaixo() {
        SindicatoTemplate sindicato = new SindicatoMetalurgico();
        String resumo = sindicato.processarReivindicacao("Joao", 2500.0);
        Assertions.assertTrue(resumo.contains("Joao"));
        Assertions.assertTrue(resumo.contains("salarioAnterior=2500.0"));
        Assertions.assertTrue(resumo.contains("novoSalario=2750.0"));
        Assertions.assertTrue(resumo.contains("percentual=0.1"));
    }

    @Test
    void deveCalcularAumentoParaSalarioMedio() {
        SindicatoTemplate sindicato = new SindicatoMetalurgico();
        String resumo = sindicato.processarReivindicacao("Maria", 5000.0);
        Assertions.assertTrue(resumo.contains("novoSalario=5350.0"));
        Assertions.assertTrue(resumo.contains("percentual=0.07"));
    }

    @Test
    void deveCalcularAumentoParaSalarioAlto() {
        SindicatoTemplate sindicato = new SindicatoMetalurgico();
        String resumo = sindicato.processarReivindicacao("Ana", 8000.0);
        Assertions.assertTrue(resumo.contains("novoSalario=8400.0"));
        Assertions.assertTrue(resumo.contains("percentual=0.05"));
    }

    @Test
    void deveValidarAssociadoObrigatorio() {
        SindicatoTemplate sindicato = new SindicatoMetalurgico();
        Assertions.assertThrows(IllegalArgumentException.class, () -> sindicato.processarReivindicacao(" ", 3000.0));
    }
}

