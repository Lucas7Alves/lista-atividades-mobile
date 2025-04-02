package com.example.plataformaeducacional;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.plataformaeducacional.model.CursoImpl;
import com.example.plataformaeducacional.model.Diogenes;

import java.util.ArrayList;
import java.util.List;

public class CursoListActivity extends AppCompatActivity {

    private ListView listViewCursos;
    private List<CursoImpl> listaDeCursos = new ArrayList<>();
    private Diogenes d;

    private ArrayAdapter<CursoImpl> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_curso_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.titlePage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        d = getIntent().getParcelableExtra("manager");
        listViewCursos = findViewById(R.id.listViewCursos);

        if (d != null && d.getListCursos() != null) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, d.getListCursos());
            listViewCursos.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Nenhum curso cadastrado", Toast.LENGTH_SHORT).show();
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
            listViewCursos.setAdapter(adapter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (d != null && adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}