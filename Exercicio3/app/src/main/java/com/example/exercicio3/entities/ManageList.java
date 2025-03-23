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
        listContatos.add(contato);
        contato.setWhereSave(chipAtual);
    }

    public List<Contato> getContatoByChip(Chip chip) {
        List<Contato> newlist = new ArrayList<>();
        for (Contato c : listContatos) {
            if (c.getWhereSave().equals(chip)) {
                newlist.add(c);
            }
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
        return newlist;
    }

    public TreeSet<Profissional> getContatoProfissional() {
        TreeSet<Profissional> newlist = new TreeSet<>();
        for (Contato c : listContatos) {
            if (c instanceof Profissional) {
                newlist.add((Profissional) c);
            }
        }
        return newlist;
    }

    public void setListChips(List<Chip> chips) {
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



