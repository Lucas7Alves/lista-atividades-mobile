package com.example.exercicio1.model.sampledata;

import com.example.exercicio1.abstracts.sampledata.Carro;

public class BuildYourDream extends Carro {

    private static final String MARCA = "BYD";  // Definição de constantes
    private static final Integer QTD_RODAS = 4;
    private static final String MOTOR = "Motor elétrico";

    private Double battery;

    public BuildYourDream(int ano, String tipoTracao) {
        super(MOTOR, MARCA, ano, QTD_RODAS, tipoTracao);
        this.battery = 100.0;
    }

    @Override
    public String marchaRe() {
        if (!isLigado()){
            return "Ligar o carro primeiro";
        }
        lossBattery(7.0);
        return "PI PI PI PI";
    }

    @Override
    public String trocarMarcha() {
        lossBattery(1.0);
        return super.trocarMarcha();
    }

    @Override
    public String ligarFarol() {
        lossBattery(2.0);
        return super.ligarFarol();
    }

    private void lossBattery(Double value) {
        this.battery -= value;
    }


    public Double getBattery() {
        return battery;
    }
}
