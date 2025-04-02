package com.example.plataformaeducacional.abstracts;

import com.example.plataformaeducacional.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Curso {
    private String nome;
    private String descricao;
    private int limitStudents;
    private List<Student> students = new ArrayList<>();

    public Curso(String nome, String descricao, int limitStudents) {
        this.nome = nome;
        this.descricao = descricao;
        this.limitStudents = limitStudents;
        this.students = new ArrayList<>();
    }

    public Curso(String name) {
        this.nome = name;
        this.students = new ArrayList<>();
    }

    public void addStudentOnCurso(Student student) {
        students.add(student);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getLimitStudents() {
        return limitStudents;
    }

    public void setLimitStudents(int limitStudents) {
        this.limitStudents = limitStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(nome, curso.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
