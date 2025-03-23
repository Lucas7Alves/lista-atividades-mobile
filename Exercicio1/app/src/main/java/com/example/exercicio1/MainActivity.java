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

        //Carro
        Log.i("Carro", byd.marchaRe());
        Log.i("Carro", byd.ligarVeiculo() + " e sua batéria está em " + byd.getBattery() + "%");

        //MotoAquática
        Log.i("Moto", jt.ligarVeiculo());
        Log.i("Moto", jt.manobra() + " e sua combustível está em " + jt.getFuel() + "%");
        Log.i("Moto", jt.buzinar());
        Log.i("Moto", "" + jt.getFuel());
    }
}