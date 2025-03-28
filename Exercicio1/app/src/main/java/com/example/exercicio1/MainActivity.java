package com.example.exercicio1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercicio1.model.sampledata.BuildYourDream;
import com.example.exercicio1.model.sampledata.JetSki;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BuildYourDream byd = new BuildYourDream(2025, "Tração integral");
        JetSki jt = new JetSki("Motor elétrico", "Honda", 2023, 2);

        // Carro
        try {
            Log.i("Carro", byd.marchaRe());
        } catch (Exception e) {
            Log.e("Carro", "Erro ao engatar marcha ré: " + e.getMessage());
        }

        try {
            Log.i("Carro", byd.ligarVeiculo() + " e sua bateria está em " + byd.getBattery() + "%");
        } catch (Exception e) {
            Log.e("Carro", "Erro ao ligar o veículo: " + e.getMessage());
        }

        // MotoAquática
        try {
            Log.i("Moto", jt.ligarVeiculo());
        } catch (Exception e) {
            Log.e("Moto", "Erro ao ligar o JetSki: " + e.getMessage());
        }

        try {
            Log.i("Moto", jt.manobra() + " e o combustível está em " + jt.getFuel() + "%");
        } catch (Exception e) {
            Log.e("Moto", "Erro ao realizar manobra: " + e.getMessage());
        }

        try {
            Log.i("Moto", jt.buzinar());
        } catch (Exception e) {
            Log.e("Moto", "Erro ao buzinar: " + e.getMessage());
        }

        try {
            Log.i("Moto", "Combustível restante: " + jt.getFuel() + "%");
        } catch (Exception e) {
            Log.e("Moto", "Erro ao obter nível de combustível: " + e.getMessage());
        }
    }
}