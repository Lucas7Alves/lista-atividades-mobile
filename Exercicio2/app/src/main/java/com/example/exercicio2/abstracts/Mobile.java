package com.example.exercicio2.abstracts;

import com.example.exercicio2.entities.Device;

public class Mobile extends Eletronico {

    private Double durability;
    private Double batteryLevel;
    public Mobile(String os, String marca, String modelo, Double durability) {
        super(os, marca, modelo);
        this.durability = 100.0;
    }

    @Override
    public boolean BluetoothConnect(Device device) {
        testIntegrity();
        return super.BluetoothConnect(device);
    }

    public void charge() {
        if (batteryLevel >= 100) {
            throw new RuntimeException("Bateria cheia");
        }
        degradation(4.0);
        this.batteryLevel += 40.0;
    }

    public String enviarSms(String numero, String mensagem) {
        return "Mensagem enviada para " + numero + ": " + mensagem;
    }

    public String ligar(String numero) {
        degradation(8.0);
        return "Ligando para " + numero;
    }

    public String tirarFoto() {
        testIntegrity();
        degradation(10.0);
        return "Foto tirada";
    }

    private void testIntegrity() {
        if (durability <= 0) {
            throw new RuntimeException("Celular quebrado");
        } else if (batteryLevel <= 0) {
            throw new RuntimeException("Bateria vazia");
        }
    }

    private void degradation(Double degradation) {
        testIntegrity();
        this.durability -= degradation;
    }
}
