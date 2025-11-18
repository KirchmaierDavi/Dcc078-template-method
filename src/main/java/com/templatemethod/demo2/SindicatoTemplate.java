package com.templatemethod.demo2;

public abstract class SindicatoTemplate {

    public final String processarReivindicacao(String associado, double salarioAtual) {
        validarAssociado(associado);
        double percentual = calcularPercentualAumento(salarioAtual);
        double novoSalario = calcularNovoSalario(salarioAtual, percentual);
        registrarNoSindicato(associado, salarioAtual, novoSalario, percentual);
        return gerarResumo(associado, salarioAtual, novoSalario, percentual);
    }

    protected abstract void validarAssociado(String associado);

    protected abstract double calcularPercentualAumento(double salarioAtual);

    protected abstract void registrarNoSindicato(String associado, double salarioAtual, double novoSalario, double percentual);

    protected String gerarResumo(String associado, double salarioAnterior, double novoSalario, double percentual) {
        return "Associado: " + associado
                + ", salarioAnterior=" + salarioAnterior
                + ", novoSalario=" + novoSalario
                + ", percentual=" + percentual;
    }

    private double calcularNovoSalario(double salarioAtual, double percentual) {
        return salarioAtual + salarioAtual * percentual;
    }
}

