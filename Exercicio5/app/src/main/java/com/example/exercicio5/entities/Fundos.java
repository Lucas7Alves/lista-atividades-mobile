package com.example.exercicio5.entities;

import com.example.exercicio5.abstracts.Investimento;
import com.example.exercicio5.enums.Risco;
import com.example.exercicio5.enums.TipoInvestimento;

import java.util.Date;

public class Fundos extends Investimento {
    private double taxaAdministracao;

    public Fundos(String nome, double valorInicial, Date dataInicio, Date dataVencimento, double taxaRetorno, Risco risco, TipoInvestimento tipoInvestimento, double taxaAdministracao) {
        super(nome, valorInicial, dataInicio, dataVencimento, taxaRetorno, risco, tipoInvestimento);
        this.taxaAdministracao = taxaAdministracao;
    }

    public double getTaxaAdministracao() {
        return taxaAdministracao;
    }

    public void setTaxaAdministracao(double taxaAdministracao) {
        this.taxaAdministracao = taxaAdministracao;
    }

    @Override
    public Double calcularRendimento() {
        if (getTaxaRetorno() < 0) {
            throw new IllegalArgumentException("A taxa de retorno não pode ser negativa.");
        }
        return (getValorInicial() * getTaxaRetorno()) - taxaAdministracao;
    }
}