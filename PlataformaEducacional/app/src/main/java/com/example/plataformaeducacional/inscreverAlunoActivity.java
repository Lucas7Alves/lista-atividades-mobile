package com.example.plataformaeducacional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.plataformaeducacional.model.CursoImpl;
import com.example.plataformaeducacional.model.Diogenes;
import com.example.plataformaeducacional.model.Student;

public class inscreverAlunoActivity extends AppCompatActivity {

    Button addAluno, finalizarInscricao;
    EditText editTextName, editTextCpf, editTextCurso;
    private Diogenes d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inscrever_aluno);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.titlePage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        d = getIntent().getParcelableExtra("manager");

        addAluno = findViewById(R.id.addAluno);

        addAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName = findViewById(R.id.editTextName);
                editTextCpf = findViewById(R.id.editTextCpf);
                editTextCurso = findViewById(R.id.editTextCurso);


                String nomeAluno = editTextName.getText().toString();
                String cpfAluno = editTextCpf.getText().toString();
                String nomeCurso = editTextCurso.getText().toString();

                Student s = new Student(nomeAluno, cpfAluno);
                CursoImpl curso = new CursoImpl(nomeCurso);

                if (editTextName.getText().toString().isEmpty() || editTextCpf.getText().toString().isEmpty() || editTextCurso.getText().toString().isEmpty()) {
                    Toast.makeText(inscreverAlunoActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                }
                assert d != null;
                CursoImpl cursoEncontrado = null;
                for (CursoImpl c : d.getListCursos()) {
                    if (c.getNome().equals(nomeCurso)) {
                        cursoEncontrado = c;
                    }
                }

                if (cursoEncontrado != null) {
                    if (!cursoEncontrado.getStudents().contains(s)) {
                        try {
                            d.addStudent(s, cursoEncontrado);
                            Toast.makeText(inscreverAlunoActivity.this, "Aluno adicionado!", Toast.LENGTH_SHORT).show();
                        } catch (RuntimeException e) {
                            Toast.makeText(inscreverAlunoActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(inscreverAlunoActivity.this, "Aluno já cadastrado!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                Toast.makeText(inscreverAlunoActivity.this, "Curso não encontrado!", Toast.LENGTH_SHORT).show();
            }
                    editTextName.setText("");
                    editTextCpf.setText("");
            }
        });

        finalizarInscricao = findViewById(R.id.finalizarInscricao);

        finalizarInscricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inscreverAlunoActivity.this, MainActivity.class);
                intent.putExtra("managerAtualizado", d);
                setResult(RESULT_OK,intent);
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