package com.example.plataformaeducacional.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.plataformaeducacional.abstracts.Curso;

public class CursoImpl extends Curso implements Parcelable {
    public CursoImpl(String nome, String descricao, int limitStudents) {
        super(nome, descricao, limitStudents);
    }

    public CursoImpl(String name) {
        super(name);
    }

    protected CursoImpl(Parcel in) {
        super(in.readString(), in.readString(), in.readInt());
    }

    public static final Creator<CursoImpl> CREATOR = new Creator<CursoImpl>() {
        @Override
        public CursoImpl createFromParcel(Parcel in) {
            return new CursoImpl(in);
        }

        @Override
        public CursoImpl[] newArray(int size) {
            return new CursoImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getNome());
        dest.writeString(getDescricao());
        dest.writeInt(getLimitStudents());
    }

    @Override
    public String toString() {
        return getNome();
    }
}
