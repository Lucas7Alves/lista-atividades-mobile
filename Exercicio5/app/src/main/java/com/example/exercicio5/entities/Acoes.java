package com.example.exercicio5.entities;

import com.example.exercicio5.abstracts.Investimento;
import com.example.exercicio5.enums.Risco;
import com.example.exercicio5.enums.TipoInvestimento;

import java.util.Date;

public class Acoes extends Investimento {
    private double valorAtual;

    public Acoes(String nome, double valorInicial, Date dataInicio, Date dataVencimento,
                 double taxaRetorno, Risco risco, TipoInvestimento tipoInvestimento, double valorAtual) {
        super(nome, valorInicial, dataInicio, dataVencimento, taxaRetorno, risco, tipoInvestimento);
        this.valorAtual = valorAtual;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    @Override
    public Double calcularRendimento() {
        return valorAtual - getValorInicial();
    }
}