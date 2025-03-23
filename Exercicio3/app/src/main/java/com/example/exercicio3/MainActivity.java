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

        // Criando Chips
        Chip chip1 = new Chip("Vivo", "1111-2222");
        Chip chip2 = new Chip("Claro", "3333-4444");
        Chip chip3 = new Chip("Laricel", "5555-7777");

        List<Chip> chipList = new ArrayList<>();
        chipList.add(chip1);
        chipList.add(chip2);
        chipList.add(chip3);

        // Criando ManageList
        TreeSet<Contato> contatosSet = new TreeSet<>();
        ManageList manageList = new ManageList(contatosSet);
        manageList.setListChips(chipList);

        // Criando Contatos
        Pessoal pessoal1 = new Pessoal("João", "9876-5432");
        Pessoal pessoal2 = new Pessoal("Maria", "1234-5678");
        Profissional profissional1 = new Profissional("Carlos", "5555-1212", "carlos@empresa.com");
        Profissional profissional2 = new Profissional("Ana", "7777-8989", "ana@empresa.com");

        // Adicionando Contatos
        manageList.addContato(pessoal1);
        manageList.setChip();
        manageList.addContato(pessoal2);
        manageList.setChip();
        manageList.addContato(profissional1);
        manageList.setChip();
        manageList.addContato(profissional2);

        // Imprimindo Contatos por Chip
        Log.d(TAG, "Contatos por Vivo:");
        for (Contato contato : manageList.getContatoByChip(chip1)) {
            Log.d(TAG, "  - " + contato.getNome() + ": " + contato.getNumero());
        }

        Log.d(TAG, "Contatos por Claro:");
        for (Contato contato : manageList.getContatoByChip(chip2)) {
            Log.d(TAG, "  - " + contato.getNome() + ": " + contato.getNumero());
        }

        // Imprimindo Todos os Contatos
        Log.d(TAG, "Todos os Contatos:");
        for (Contato contato : manageList.getAllContatos()) {
            Log.d(TAG, "  - " + contato.getNome() + ": " + contato.getNumero());
        }

        // Imprimindo Contatos Pessoais
        Log.d(TAG, "Contatos Pessoais:");
        for (Pessoal contato : manageList.getContatoPessoal()) {
            Log.d(TAG, "  - " + contato.getNome() + ": " + contato.getNumero());
        }

        // Imprimindo Contatos Profissionais
        Log.d(TAG, "Contatos Profissionais:");
        for (Profissional contato : manageList.getContatoProfissional()) {
            Log.d(TAG, "  - " + contato.getNome() + ": " + contato.getNumero() + " - " + contato.getEmail());
        }

        // Mudando o Chip Atual
        manageList.setChip();
        Log.d(TAG, "Chip Atual mudado para: " + manageList.getContatoByChip(chip2).get(0).getWhereSave().getNome());
        manageList.setChip();
        Log.d(TAG, "Chip Atual mudado para: " + manageList.getContatoByChip(chip3).get(0).getWhereSave().getNome());
        manageList.setChip();
        Log.d(TAG, "Chip Atual mudado para: " + manageList.getContatoByChip(chip1).get(0).getWhereSave().getNome());

        // Usando métodos específicos de Pessoal e Profissional
        Log.d(TAG, "Mensagem de Pessoal1: " + pessoal1.enviarSms(pessoal2));
        Log.d(TAG, "Ligação de Profissional1: " + profissional1.ligarParaColegaEquipeNoFds(profissional2));
        Log.d(TAG, "Email de Profissional2: " + profissional2.enviarEmail(profissional1, "Reunião de equipe"));
    }
}