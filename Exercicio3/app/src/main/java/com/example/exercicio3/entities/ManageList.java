package com.example.exercicio3.entities;

import com.example.exercicio3.interfaces.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ManageList {

    private List<Chip> chips;
    private Chip chipAtual;

    private TreeSet<Contato> listContatos = new TreeSet<>();

    public ManageList(TreeSet<Contato> setContatos) {
        this.listContatos = setContatos;
        this.chips = new ArrayList<>();
    }

    public void addContato(Contato contato) {
        if (contato == null) {
            throw new IllegalArgumentException("Contato não pode ser nulo");
        }
        listContatos.add(contato);
        contato.setWhereSave(chipAtual);
    }

    public List<Contato> getContatoByChip(Chip chip) {
        if (chip == null) {
            throw new IllegalArgumentException("Chip não pode ser nulo");
        }
        List<Contato> newlist = new ArrayList<>();
        for (Contato c : listContatos) {
            if (c.getWhereSave().equals(chip)) {
                newlist.add(c);
            }
        }
        if (newlist.isEmpty()) {
            throw new IllegalArgumentException("Nenhum contato encontrado no chip " + chip.getNome());
        }
        return newlist;
    }

    public TreeSet<Contato> getAllContatos() {
        return listContatos;
    }

    public TreeSet<Pessoal> getContatoPessoal() {
        TreeSet<Pessoal> newlist = new TreeSet<>();
        for (Contato c : listContatos) {
            if (c instanceof Pessoal) {
                newlist.add((Pessoal) c);
            }
        }
        if (newlist.isEmpty()) {
            throw new IllegalArgumentException("Nenhum contato pessoal encontrado");
        }
        return newlist;
    }

    public TreeSet<Profissional> getContatoProfissional() {
        TreeSet<Profissional> newlist = new TreeSet<>();
        for (Contato c : listContatos) {
            if (c instanceof Profissional) {
                newlist.add((Profissional) c);
            }
        }
        if (newlist.isEmpty()) {
            throw new IllegalArgumentException("Nenhum contato profissional encontrado");
        }
        return newlist;
    }

    public void setListChips(List<Chip> chips) {
        if (chips.isEmpty()) {
            throw new IllegalArgumentException("Lista de chips não pode estar vazia");
        }
        this.chips = chips;
        this.chipAtual = chips.get(0);
    }

    public void setChip() {
        int size = chips.size();
        if (chips.indexOf(chipAtual) < size - 1) {
            chipAtual = chips.get(chips.indexOf(chipAtual) + 1);
        } else {
            chipAtual = chips.get(0);
        }
    }
}



