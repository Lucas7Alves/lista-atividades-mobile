package com.example.exercicio5.entities;

import com.example.exercicio5.abstracts.Investimento;
import com.example.exercicio5.enums.Risco;
import com.example.exercicio5.enums.TipoInvestimento;

import java.util.Calendar;
import java.util.Date;

public class Titulos extends Investimento {
    private double taxaJuros;

    public Titulos(String nome, double valorInicial, Date dataInicio, Date dataVencimento,
                   double taxaRetorno, Risco risco, TipoInvestimento tipoInvestimento, double taxaJuros) {
        super(nome, valorInicial, dataInicio, dataVencimento, taxaRetorno, risco, tipoInvestimento);
        this.taxaJuros = taxaJuros;
    }

    @Override
    public Double calcularRendimento() {
        return getValorInicial() * taxaJuros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public Double calcularRedimentoFinal() {
        Date dataInicial = getDataInicio();
        Date dataFinal = getDataVencimento();

        if (dataFinal.before(dataInicial)) {
            throw new IllegalArgumentException("A data final não pode ser anterior à data inicial.");
        }
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(dataInicial);

        Calendar calendarFinal = Calendar.getInstance();
        calendarFinal.setTime(dataFinal);

        int meses = calendarInicio.get(Calendar.MONTH) - calendarFinal.get(Calendar.MONTH);

        int anos = calendarFinal.get(Calendar.YEAR) - calendarInicio.get(Calendar.YEAR);

        Double value = 0.0;
        for (int i = 0; i < anos * 12 + meses; i++) {
            value += calcularRendimento();
        }
        return value;
    }
}