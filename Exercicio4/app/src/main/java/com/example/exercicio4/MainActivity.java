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

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Manager manager = new Manager();

        Calendar calendar = Calendar.getInstance();

        calendar.set(2023, Calendar.NOVEMBER, 15);
        Date data1 = calendar.getTime();
        Transacao receita1 = new Transacao("Salário", data1, "Salário de Novembro", 3000.0, TipoTransacao.RECEITA);

        calendar.set(2023, Calendar.NOVEMBER, 20);
        Date data2 = calendar.getTime();
        Transacao despesa1 = new Transacao("Aluguel", data2, "Aluguel de Novembro", 1200.0, TipoTransacao.DESPESA);

        calendar.set(2023, Calendar.NOVEMBER, 25);
        Date data3 = calendar.getTime();
        Transacao despesa2 = new Transacao("Supermercado", data3, "Compras do mês", 500.0, TipoTransacao.DESPESA);

        calendar.set(2023, Calendar.DECEMBER, 1);
        Date data4 = calendar.getTime();
        Transacao receita2 = new Transacao("Renda Extra", data4, "Trabalho Freelancer", 800.0, TipoTransacao.RECEITA);

        try {
            manager.beforeAddTransacao(receita1, true);
            manager.beforeAddTransacao(despesa1, true);
            manager.beforeAddTransacao(despesa2, true);
            manager.beforeAddTransacao(receita2, true);
        } catch (RuntimeException e) {
            Log.e(TAG, "Erro ao adicionar transação: " + e.getMessage());
        }

        try {
            List<Transacao> despesas = manager.getDespesas();
            Log.d(TAG, "Despesas: " + despesas);
        } catch (RuntimeException e) {
            Log.e(TAG, "Erro ao obter despesas: " + e.getMessage());
        }

        try {
            List<Transacao> receitas = manager.getReceitas();
            Log.d(TAG, "Receitas: " + receitas);
        } catch (RuntimeException e) {
            Log.e(TAG, "Erro ao obter receitas: " + e.getMessage());
        }

        try {
            double saldo = manager.calcularSaldo();
            Log.d(TAG, "Saldo: " + saldo);
        } catch (RuntimeException e) {
            Log.e(TAG, "Erro ao calcular saldo: " + e.getMessage());
        }

        try {
            String saldoDetalhado = manager.calcularSaldoDetalhado();
            Log.d(TAG, "Saldo Detalhado: " + saldoDetalhado);
        } catch (RuntimeException e) {
            Log.e(TAG, "Erro ao calcular saldo detalhado: " + e.getMessage());
        }

        try {
            List<Transacao> revisaoValor = manager.revisarTransacoes(400.0, 1500.0);
            Log.d(TAG, "Revisão por Valor: " + revisaoValor);
        } catch (RuntimeException e) {
            Log.e(TAG, "Erro ao revisar transações por valor: " + e.getMessage());
        }

        try {
            calendar.set(2023, Calendar.NOVEMBER, 18);
            Date inicio = calendar.getTime();
            calendar.set(2023, Calendar.DECEMBER, 2);
            Date fim = calendar.getTime();

            List<Transacao> revisaoData = manager.revisarTransacoes(inicio, fim);
            Log.d(TAG, "Revisão por Data: " + revisaoData);
        } catch (RuntimeException e) {
            Log.e(TAG, "Erro ao revisar transações por data: " + e.getMessage());
        }
    }
}
