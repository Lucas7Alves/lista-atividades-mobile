package com.example.exercicio2.entities;

import com.example.exercicio2.abstracts.Desktop;

public class Lenovo extends Desktop {

    private static final String marca = "Lenovo";
    private Double processLevel;
    public Lenovo(String os, String marca, String modelo, boolean hasBluetooth) {
        super(os, marca, modelo, hasBluetooth);
    }

    public String openOverWatch() {
        return "Overwatch aberto";

    }

    private String coolerUsage() {
        if (processLevel <= 10) {
            return "Cooler desligado";
        } else if (processLevel > 10 && processLevel < 40)  {
            return "Cooler ligado";
        } else if (processLevel >= 40 && processLevel <= 50) {
            return "Barulhos mais intensos do cooler";
        } else {
            return "Você ouve uma turbina de avião";
        }
    }

}
