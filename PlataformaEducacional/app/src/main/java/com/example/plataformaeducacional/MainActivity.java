package com.example.plataformaeducacional;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.plataformaeducacional.model.Diogenes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //TODO: Fazer tela inscrever aluno

    private static final int CADASTRO_REQUEST_CODE = 1;
    Button btCadastrar, btInscrever, btListarCurso;

    private Diogenes diogenes;
    private final ActivityResultLauncher<Intent> cadastroLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null && data.hasExtra("manager")) {
                        diogenes = data.getParcelableExtra("manager");
                        Log.d("DEBUG", "Curso adicionado! Total: " + diogenes.getListCursos().size());
                    }
                }
            }
    );

    private final ActivityResultLauncher<Intent> inscreverAlunoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    diogenes = result.getData().getParcelableExtra("managerAtualizado");
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.titlePage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState != null) {
            diogenes = savedInstanceState.getParcelable("manager");
        } else {
            diogenes = new Diogenes(new ArrayList<>());
        }

        btCadastrar = findViewById(R.id.cadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                intent.putExtra("manager", diogenes);
                Log.d("FLUXO", "Antes de abrir cadastro: " + diogenes.getListCursos().size());
                cadastroLauncher.launch(intent);
            }
        });

        btListarCurso = findViewById(R.id.visualizar_lista);

        btListarCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CursoListActivity.class);
                intent.putExtra("manager", diogenes);
                startActivity(intent);
            }
        });

        btInscrever = findViewById(R.id.inscrever_aluno);

        btInscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, inscreverAlunoActivity.class);
                intent.putExtra("manager", diogenes);
                inscreverAlunoLauncher.launch(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("manager", diogenes);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }
}