package com.example.exercicio2.abstracts;

import android.util.Log;

import com.example.exercicio2.entities.Device;

public class Desktop extends Eletronico{

    private Double processLevel;

    private final boolean hasBluetooth;
    public Desktop(String os, String marca, String modelo, boolean hasBluetooth) {
        super(os, marca, modelo);
        this.hasBluetooth = hasBluetooth;
    }

    @Override
    public boolean BluetoothConnect(Device device) {
        if (!hasBluetooth) {
            throw new RuntimeException("Desktop não possui bluetooth");
        }
        return super.BluetoothConnect(device);
    }

    public boolean UsbConnect(Device device) {
        if (device == null) {
            throw new RuntimeException("Dispositivo não encontrado");
        } else {
            Log.i("Device", "UsbConnect: tum tululum");
            return true;
        }
    }

    public void ligarDesktop() {
        if (isOnEnergy()){
            processLevel += 5;
            Log.i("Desktop", "turnOn: Desktop ligado");

        } else {
            processLevel = 0.0;
            Log.i("Desktop", "turnOff: Desktop desligado");
        }
        turnOnOff();
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

    public void varreduraAntiVirus() {
        processLevel += 30;
        Log.i("Desktop", "varredura do anti-virus iniciada... " + coolerUsage());
    }

    public void finalizarVarredura() {
        processLevel -= 30;
        Log.i("Desktop", "finalizada varredura: " + coolerUsage());
    }


    public void abrirNavegador() {
        processLevel += 10;
        Log.i("Desktop", "abrir navegador: Navegador aberto," + coolerUsage());
    }

    public void fecharNavegador() {
        processLevel -= 10;
        Log.i("Desktop", "fechar navegador: Navegador fechado," + coolerUsage());
    }

    public void atualizarDrivers() {
        Log.i("Desktop", "atualizar drivers: Drivers atualizados");
    }

    public void atualizarSO() {
        processLevel += 20;
        Log.i("Desktop", "atualizar SO: SO atualizada");
    }
}
