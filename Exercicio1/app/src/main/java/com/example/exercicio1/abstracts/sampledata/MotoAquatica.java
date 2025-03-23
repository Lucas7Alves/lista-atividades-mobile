package com.example.exercicio1.abstracts.sampledata;

public abstract class MotoAquatica extends Veiculo{
    public MotoAquatica(String tipoMotor, String marca, int ano, Integer qtdRodas) {
        super(tipoMotor, marca, ano, qtdRodas);
    }

    public String manobra() {
        return "Manobra";
    }
}
