package com.example.exercicio4.entities;

import androidx.annotation.NonNull;

import com.example.exercicio4.enums.TipoTransacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transacao {

    private String destinatario;
    private Date date;
    private String descricao;
    private Double valor;
    private TipoTransacao tipo;

    public Transacao(String destinatario, Date date, String descricao, Double valor, TipoTransacao tipo) {
        this.destinatario = destinatario;
        this.date = date;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public Date getDate() {
        return date;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    @NonNull
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        return "Transacao{" +
                "destinatario='" + destinatario + '\'' +
                ", date=" + sdf.format(date) +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", tipo=" + tipo +
                '}';
    }
}
