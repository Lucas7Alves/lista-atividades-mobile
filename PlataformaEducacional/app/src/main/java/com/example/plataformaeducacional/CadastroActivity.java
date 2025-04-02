package com.example.plataformaeducacional;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.plataformaeducacional.model.CursoImpl;
import com.example.plataformaeducacional.model.Diogenes;

public class CadastroActivity extends AppCompatActivity {

    Button btAddCurso, btFinalizar;
    EditText nome, descricao, limite;
    private Diogenes d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        d = getIntent().getParcelableExtra("manager");

        btAddCurso = findViewById(R.id.cadastrarCurso);
        btFinalizar = findViewById(R.id.finalizarCadastro);
        nome = findViewById(R.id.nome);
        descricao = findViewById(R.id.descricao);
        limite = findViewById(R.id.limite);

        btAddCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.getText().toString().isEmpty() ||
                        descricao.getText().toString().isEmpty() ||
                        limite.getText().toString().isEmpty()) {

                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    CursoImpl c = new CursoImpl(
                            nome.getText().toString(),
                            descricao.getText().toString(),
                            Integer.parseInt(limite.getText().toString()));
                    Log.d("FLUXO", "Curso adicionado: " + c.getNome());
                    d.addCurso(c);

                    nome.setText("");
                    descricao.setText("");
                    limite.setText("");

                    Toast.makeText(CadastroActivity.this, "Curso cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(CadastroActivity.this, "Olha eu aqui!", Toast.LENGTH_SHORT).show();
            }
        });

        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("manager", d);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
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