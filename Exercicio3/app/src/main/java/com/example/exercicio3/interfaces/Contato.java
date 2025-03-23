package com.example.exercicio3.interfaces;

import com.example.exercicio3.entities.Chip;

public interface Contato {
    String getNome();
    String getNumero();
    String getEmail();
    String enviarSms(Contato contato);

    Chip getWhereSave();

    void setWhereSave(Chip chipAtual);
}
