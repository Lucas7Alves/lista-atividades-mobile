package com.example.exercicio2.entities;

public class Rede {
    private String password;
    private String name;

    public Rede(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}
