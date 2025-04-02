package com.example.plataformaeducacional.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.plataformaeducacional.interfaces.IManager;

import java.util.ArrayList;
import java.util.List;

public class Diogenes implements IManager, Parcelable {

    private List<CursoImpl> listCursos = new ArrayList<>();

    public Diogenes(List<CursoImpl> listCursos) {
        this.listCursos = listCursos;
    }

    public Diogenes() {
    }

    protected Diogenes(Parcel in) {
        listCursos = in.readArrayList(CursoImpl.class.getClassLoader());
    }

    public static final Creator<Diogenes> CREATOR = new Creator<Diogenes>() {
        @Override
        public Diogenes createFromParcel(Parcel in) {
            return new Diogenes(in);
        }

        @Override
        public Diogenes[] newArray(int size) {
            return new Diogenes[size];
        }
    };

    @Override
    public void addStudent(Student student, CursoImpl curso) {
        if (curso.getStudents().size() < curso.getLimitStudents()) {
            curso.addStudentOnCurso(student);
        } else {
            throw new RuntimeException("The course is full. You can't add more student yet");
        }
    }

    @Override
    public void addCurso(CursoImpl curso) {
        listCursos.add(curso);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(listCursos);
    }

    public void setListCursos(List<CursoImpl> listCursos) {
        this.listCursos = listCursos;
    }

    public List<CursoImpl> getListCursos() {
        return listCursos;
    }



}
