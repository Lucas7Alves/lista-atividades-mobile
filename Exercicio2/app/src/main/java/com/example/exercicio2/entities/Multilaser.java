package com.example.exercicio2.entities;

import com.example.exercicio2.abstracts.Mobile;

public class Multilaser extends Mobile {
    public Multilaser(String os, String marca, String modelo, Double durability) {
        super(os, marca, modelo, durability);
    }

    public String baixarArqvSuspeito(String http) {
        return "Arquivo baixado." + " \nAVISO: \nSeu celular ocasionalmente começa a esquentar sem processos aparentes";
    }
}
