package com.example.exercicio3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercicio3.entities.Chip;
import com.example.exercicio3.entities.ManageList;
import com.example.exercicio3.entities.Pessoal;
import com.example.exercicio3.entities.Profissional;
import com.example.exercicio3.interfaces.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chip chip1 = new Chip("Vivo", "1111-2222");
        Chip chip2 = new Chip("Claro", "3333-4444");
        Chip chip3 = new Chip("Laricel", "5555-7777");

        List<Chip> chipList = new ArrayList<>();
        chipList.add(chip1);
        chipList.add(chip2);
        chipList.add(chip3);

        TreeSet<Contato> contatosSet = new TreeSet<>();
        ManageList manageList = new ManageList(contatosSet);

        try {
            manageList.setListChips(chipList);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Erro ao definir a lista de chips: " + e.getMessage());
        }

        Pessoal pessoal1 = new Pessoal("João", "9876-5432");
        Pessoal pessoal2 = new Pessoal("Maria", "1234-5678");
        Profissional profissional1 = new Profissional("Carlos", "5555-1212", "carlos@empresa.com");
        Profissional profissional2 = new Profissional("Ana", "7777-8989", "ana@empresa.com");

        try {
            manageList.addContato(pessoal1);
            manageList.setChip();
            manageList.addContato(pessoal2);
            manageList.setChip();
            manageList.addContato(profissional1);
            manageList.setChip();
            manageList.addContato(profissional2);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Erro ao adicionar contato: " + e.getMessage());
        }

        try {
            Log.d(TAG, "Contatos por Vivo:");
            for (Contato contato : manageList.getContatoByChip(chip1)) {
                Log.d(TAG, "  - " + contato.getNome() + ": " + contato.getNumero());
            }
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage());
        }

        try {
            Log.d(TAG, "Contatos Pessoais:");
            for (Pessoal contato : manageList.getContatoPessoal()) {
                Log.d(TAG, "  - " + contato.getNome() + ": " + contato.getNumero());
            }
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage());
        }

        try {
            Log.d(TAG, "Contatos Profissionais:");
            for (Profissional contato : manageList.getContatoProfissional()) {
                Log.d(TAG, "  - " + contato.getNome() + ": " + contato.getNumero() + " - " + contato.getEmail());
            }
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage());
        }

        try {
            manageList.setChip();
            Log.d(TAG, "Chip Atual mudado para: " + manageList.getContatoByChip(chip2).get(0).getWhereSave().getNome());
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Erro ao obter contato pelo chip: " + e.getMessage());
        }
    }
}