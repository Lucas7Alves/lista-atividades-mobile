package com.example.exercicio1.abstracts.sampledata;

public abstract class Carro extends Veiculo {
    private String tipoTracao;

    public Carro(String tipoMotor, String marca, int ano, Integer qtdRodas, String tipoTracao) {
        super(tipoMotor, marca, ano, qtdRodas);
        this.tipoTracao = tipoTracao;
    }

    public abstract String marchaRe();
}
