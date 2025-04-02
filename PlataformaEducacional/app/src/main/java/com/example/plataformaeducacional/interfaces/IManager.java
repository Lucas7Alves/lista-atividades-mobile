package com.example.plataformaeducacional.interfaces;

import com.example.plataformaeducacional.model.CursoImpl;
import com.example.plataformaeducacional.model.Student;

public interface IManager {

    public void addStudent(Student student, CursoImpl curso);
    public void addCurso(CursoImpl curso);
}
