package com.example.exercicio3.entities;

import com.example.exercicio3.abstracts.fieldContato;
import com.example.exercicio3.interfaces.Contato;

public class Pessoal extends fieldContato {


    public Pessoal(String nome, String numero) {
        super(nome, numero, null, null);
    }

    @Override
    public String enviarSms(Contato contato) {
        return "Enviando mentiras para: " + contato.getNome();
    }
}
