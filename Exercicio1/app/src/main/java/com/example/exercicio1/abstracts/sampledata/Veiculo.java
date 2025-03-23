package com.example.exercicio1.abstracts.sampledata;

public abstract class Veiculo {
    private String tipoMotor;
    private String marca;
    private int ano;
    private Integer qtdRodas;
    protected boolean ligado;

    public Veiculo(String tipoMotor, String marca, int ano, Integer qtdRodas) {
        this.tipoMotor = tipoMotor;
        this.marca = marca;
        this.ano = ano;
        this.qtdRodas = qtdRodas;
        this.ligado = false;
    }

    public String ligarVeiculo() {
        this.ligado = !isLigado();
        if (this.ligado) {
            return "Ligando o carro";
        } else {
            return "Desligando o carro";
        }
    }

    public String ligarFarol() {
        if (!isLigado()){
            return "Ligar o carro primeiro";
        }
        return "Farol ligado";
    }

    public String trocarMarcha() {
        if (!isLigado()){
            return "Ligar o carro primeiro";
        }
        return "Trocando marcha";
    }

    public boolean isLigado() {
        return ligado;
    }

}
