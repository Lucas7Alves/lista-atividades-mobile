package com.example.exercicio5.abstracts;

import com.example.exercicio5.enums.Risco;
import com.example.exercicio5.enums.TipoInvestimento;
import com.example.exercicio5.interfaces.ICalculosInvestimento;

import java.util.Date;

public abstract class Investimento implements ICalculosInvestimento {
    private String nome;
    private Double valorInicial;
    private Date dataInicio;
    private Date dataVencimento;
    private Double taxaRetorno;
    private Risco risco;
    private TipoInvestimento tipoInvestimento;

    public Investimento(String nome, Double valorInicial, Date dataInicio, Date dataVencimento,
                        Double taxaRetorno, Risco risco, TipoInvestimento tipoInvestimento) {
        this.nome = nome;
        this.valorInicial = valorInicial;
        this.dataInicio = dataInicio;
        this.dataVencimento = dataVencimento;
        this.taxaRetorno = taxaRetorno;
        this.risco = risco;
        this.tipoInvestimento = tipoInvestimento;
    }

    public String getNome() {
        return nome;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Double getTaxaRetorno() {
        return taxaRetorno;
    }

    public Risco getRisco() {
        return risco;
    }

    public TipoInvestimento getTipoInvestimento() {
        return tipoInvestimento;
    }
}
