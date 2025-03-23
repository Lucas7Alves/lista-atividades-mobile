package com.example.exercicio3.entities;

import com.example.exercicio3.abstracts.fieldContato;
import com.example.exercicio3.interfaces.Contato;

public class Profissional extends fieldContato {
    public Profissional(String nome, String numero, String email) {
        super(nome, numero, null, email);
    }

    public String ligarParaColegaEquipeNoFds(Contato contato) {
        return "Pertubando o colega " + contato.getNome() + "...";
    }

    public String enviarEmail(Contato contato, String msg) {
        return "Enviando email para " + contato.getNome()
                + " com mensagem: " + msg;
    }

    @Override
    public String enviarSms(Contato contato) {
        return "Enviado mensagem para " + contato.getNome();
    }
}
