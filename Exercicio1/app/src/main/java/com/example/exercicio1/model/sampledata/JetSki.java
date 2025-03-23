package com.example.exercicio1.model.sampledata;

import androidx.annotation.NonNull;

import com.example.exercicio1.abstracts.sampledata.MotoAquatica;

public class JetSki extends MotoAquatica {

    private Double fuel;


    public JetSki(String tipoMotor, String marca, int ano, Integer qtdRodas) {
        super(tipoMotor, marca, ano, qtdRodas);
    }

    public String manobra() {
        lossFuel(12.0);
        return "Manobra";
    }

    public String buzinar() {
        lossFuel(3.0);
        return "BIBI";
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    private void lossFuel(Double value) {
        if (this.fuel == null) {
            throw new NullPointerException("Combustível vazio!");
        }
        this.fuel -= value;
    }

    public Double getFuel() {
        return fuel;
    }
}
