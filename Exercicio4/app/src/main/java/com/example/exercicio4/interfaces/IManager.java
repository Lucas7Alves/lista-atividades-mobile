package com.example.exercicio4.interfaces;

import com.example.exercicio4.entities.Transacao;

import java.util.Date;
import java.util.List;

public interface IManager {

    List<Transacao> getDespesas();
    List<Transacao> getReceitas();
    String calcularSaldoDetalhado();

    Double calcularSaldo();
    List<Transacao> revisarTransacoes(Double valorMin, Double valorMax);

    List<Transacao> revisarTransacoes(Date inicio, Date fim);
}
