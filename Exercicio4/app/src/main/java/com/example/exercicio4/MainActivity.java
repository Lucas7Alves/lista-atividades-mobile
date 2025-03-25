package com.example.exercicio4;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercicio4.entities.Manager;
import com.example.exercicio4.entities.Transacao;
import com.example.exercicio4.enums.TipoTransacao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Manager manager = new Manager();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 10, 15);
        Date data1 = calendar.getTime();
        Transacao receita1 = new Transacao("Salário", data1, "Salário de Novembro", 3000.0, TipoTransacao.RECEITA);

        calendar.set(2023, 10, 20);
        Date data2 = calendar.getTime();
        Transacao despesa1 = new Transacao("Aluguel", data2, "Aluguel de Novembro", 1200.0, TipoTransacao.DESPESA);

        calendar.set(2023, 10, 25);
        Date data3 = calendar.getTime();
        Transacao despesa2 = new Transacao("Supermercado", data3, "Compras do mês", 500.0, TipoTransacao.DESPESA);

        calendar.set(2023, 11, 1);
        Date data4 = calendar.getTime();
        Transacao receita2 = new Transacao("Renda Extra", data4, "Trabalho Freelancer", 800.0, TipoTransacao.RECEITA);

        manager.beforeAddTransacao(receita1, true);
        manager.beforeAddTransacao(despesa1, true);
        manager.beforeAddTransacao(despesa2, true);
        manager.beforeAddTransacao(receita2, true);

        List<Transacao> despesas = manager.getDespesas();
        List<Transacao> receitas = manager.getReceitas();

        double saldo = manager.calcularSaldo();
        String saldoDetalhado = manager.calcularSaldoDetalhado();

        List<Transacao> revisaoValor = manager.revisarTransacoes(400.0, 1500.0);

        calendar.set(2023, 10, 18);
        Date inicio = calendar.getTime();
        calendar.set(2023, 11, 2);
        Date fim = calendar.getTime();
        List<Transacao> revisaoData = manager.revisarTransacoes(inicio, fim);

        Log.d("MainActivity", "Despesas: " + despesas.toString());
        Log.d("MainActivity", "Receitas: " + receitas.toString());
        Log.d("MainActivity", "Saldo: " + saldo);
        Log.d("MainActivity", "Saldo Detalhado: " + saldoDetalhado);
        Log.d("MainActivity", "Revisão por Valor: " + revisaoValor.toString());
        Log.d("MainActivity", "Revisão por Data: " + revisaoData.toString());
    }
}