package com.templatemethod.demo2;

public class SindicatoMetalurgico extends SindicatoTemplate {

    private boolean valido;

    @Override
    protected void validarAssociado(String associado) {
        if (associado == null || associado.trim().isEmpty()) {
            throw new IllegalArgumentException("Associado invalido");
        }
        this.valido = true;
    }

    @Override
    protected double calcularPercentualAumento(double salarioAtual) {
        if (!valido) {
            throw new IllegalStateException("Associado nao validado");
        }
        if (salarioAtual < 3000.0) {
            return 0.10;
        } else if (salarioAtual <= 7000.0) {
            return 0.07;
        }
        return 0.05;
    }

    @Override
    protected void registrarNoSindicato(String associado, double salarioAtual, double novoSalario, double percentual) {
        this.valido = false;
    }
}

