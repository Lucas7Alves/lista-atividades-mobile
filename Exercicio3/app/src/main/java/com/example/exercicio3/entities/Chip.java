package com.example.exercicio3.entities;

public class Chip {
    private String nome;
    private String numero;
    private boolean selecionado;

    public Chip(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
        this.selecionado = false;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

}
