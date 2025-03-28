package com.example.exercicio4.entities;

import com.example.exercicio4.enums.TipoTransacao;
import com.example.exercicio4.interfaces.IManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager implements IManager {

    private List<Transacao> transacoes;

    public Manager() {
        this.transacoes = new ArrayList<>();
    }

    public void beforeAddTransacao(Transacao transacao, boolean response) {
        if (response) {
            transacoes.add(transacao);
        } else {
            throw new RuntimeException("Operação cancelada!");
        }
    }

    private void adicionarTransacao(Transacao transacao) {
        if (transacao == null) {
            throw new RuntimeException("Transação inválida!");
        }
        if (transacao.getValor() <= 0.0) {
            throw new RuntimeException("Valor inválido!");
        }
        transacoes.add(transacao);
    }

    @Override
    public List<Transacao> getDespesas() {
        List<Transacao> despesas = new ArrayList<>();
        for (Transacao t : transacoes) {
            if (t.getTipo() == TipoTransacao.DESPESA) {
                despesas.add(t);
            }
        }
        if (despesas.isEmpty()) {
            throw new RuntimeException("Nenhuma despesa encontrada!");
        }
        return despesas;
    }

    @Override
    public List<Transacao> getReceitas() {
        List<Transacao> receitas = new ArrayList<>();
        for (Transacao t : transacoes) {
            if (t.getTipo() == TipoTransacao.RECEITA) {
                receitas.add(t);
            }
        }
        if (receitas.isEmpty()) {
            throw new RuntimeException("Nenhuma receita encontrada!");
        }
        return receitas;
    }


    @Override
    public String calcularSaldoDetalhado() {
        List<Transacao> despesas = getDespesas();
        List<Transacao> receitas = getReceitas();

        Double valorReceita = 0.0;
        Double valorDespesa = 0.0;

        for (Transacao t : despesas) {
            valorDespesa += t.getValor();
        }

        for (Transacao t : receitas) {
            valorReceita += t.getValor();
        }
        return "O saldo atual é de: " + (valorReceita - valorDespesa) + " reais. " +
                "Com base na receita atual de: " + valorReceita +
                " reais e na despesa atual de: " + valorDespesa + " reais.";
    }

    @Override
    public Double calcularSaldo() {
        List<Transacao> despesas = getDespesas();
        List<Transacao> receitas = getReceitas();

        Double valorReceita = 0.0;
        Double valorDespesa = 0.0;

        for (Transacao t : despesas) {
            valorDespesa += t.getValor();
        }

        for (Transacao t : receitas) {
            valorReceita += t.getValor();
        }

        return valorReceita - valorDespesa;

    }

    @Override
    public List<Transacao> revisarTransacoes(Double valorMin, Double valorMax) {
        List<Transacao> transacoesFiltradas = new ArrayList<>();
        if (valorMin < 0.0 || valorMax <= 0.0) {
            throw new RuntimeException("Parâmetros inválidos!");
        }
        for (Transacao t : transacoes) {
            if (t.getValor() >= valorMin && t.getValor() <= valorMax) {
                transacoesFiltradas.add(t);
            }
        }
        return transacoesFiltradas;
    }

    @Override
    public List<Transacao> revisarTransacoes(Date inicio, Date fim) {
        if (inicio == null || fim == null) {
            throw new RuntimeException("Parâmetros inválidos!");
        }
        List<Transacao> transacoesFiltradas = new ArrayList<>();
        for (Transacao t : transacoes) {
            if (t.getDate().after(inicio) && t.getDate().before(fim)) {
                transacoesFiltradas.add(t);
            }
        }
        return transacoesFiltradas;
    }
}
