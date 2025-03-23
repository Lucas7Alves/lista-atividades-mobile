package com.example.exercicio3.abstracts;

import com.example.exercicio3.entities.Chip;
import com.example.exercicio3.interfaces.Contato;

public abstract class fieldContato implements Contato, Comparable<Contato> {
    private String nome;
    private String numero;
    private Chip whereSave;
    private String email;


    public fieldContato(String nome, String numero, Chip whereSave, String email) {
        this.nome = nome;
        this.numero = numero;
        this.whereSave = whereSave;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    public String getNumero() {
        return numero;
    }
    public Chip getWhereSave() {
        return whereSave;
    }

    private void setNome(String nome) { this.nome = nome; }

    private void setNumero(String numero) { this.numero = numero; }
    public void setWhereSave(Chip whereSave) {
        this.whereSave = whereSave;
    }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String getEmail() { return email; }

    @Override
    public int compareTo(Contato o) {
        int numeroCompare = this.nome.compareTo(o.getNome());
        if (numeroCompare != 0) {
            return numeroCompare;
        }
        return this.numero.compareTo(o.getNumero());
    }
}
