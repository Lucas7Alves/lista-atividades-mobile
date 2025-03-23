package com.example.exercicio2.abstracts;

import android.util.Log;

import com.example.exercicio2.entities.Device;
import com.example.exercicio2.entities.Rede;

public abstract class Eletronico {
    private boolean onEnergy;
    private String os;
    private String marca;
    private String modelo;

    public Eletronico(String os, String marca, String modelo) {
        this.onEnergy = false;
        this.os = os;
        this.marca = marca;
        this.modelo = modelo;
    }

    public boolean WifiConnect(Rede rede, String password) {
        if (rede.verifyPassword(password)) {
            Log.i("Wifi", "WifiConnect: erro de conexão verifique a senha");
            return false;
        } else {
            Log.i("Wifi", "WifiConnect: Sucessfuly");
            return true;
        }
    }
    public boolean BluetoothConnect(Device device) {
        if (device == null) {
            Log.i("Bluetooth", "BluetoothConnect: Dispositivo não encontrado!");
        } else {
            Log.i("Bluetooth", "BluetoothConnect: Cebrutiu twice, conetion sucessfuly");
        }
        return device != null;
    }

    public void turnOnOff() {
        this.onEnergy = !this.onEnergy;
    }

    public boolean isOnEnergy() {
        return onEnergy;
    }

    public String getOs() {
        return os;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
