package com.example.exercicio5;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercicio5.entities.Acoes;
import com.example.exercicio5.entities.Fundos;
import com.example.exercicio5.entities.Titulos;
import com.example.exercicio5.enums.Risco;
import com.example.exercicio5.enums.TipoInvestimento;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        Date dataInicio = calendar.getTime();

        calendar.add(Calendar.YEAR, 1);
        Date dataVencimento = calendar.getTime();

        Acoes acaoPetrobras = new Acoes(
                "Petrobras PN", 100.0, dataInicio, null, 0.05, Risco.ALTO, TipoInvestimento.ACOES, 110.0
        );

        Titulos tesouroSelic = new Titulos(
                "Tesouro Selic 2026", 1000.0, dataInicio, dataVencimento, 0.01, Risco.BAIXO, TipoInvestimento.TITULOS, 0.008
        );

        Fundos fundoRendaFixa = new Fundos(
                "Fundo DI Master", 500.0, dataInicio, null, 0.02, Risco.MEDIO, TipoInvestimento.FUNDOS, 5.0
        );


        Log.d("Investimento", "Ação - Nome: " + acaoPetrobras.getNome());
        Log.d("Investimento", "Ação - Valor Inicial: " + acaoPetrobras.getValorInicial());
        Log.d("Investimento", "Ação - Data Início: " + acaoPetrobras.getDataInicio());
        Log.d("Investimento", "Ação - Data Vencimento: " + acaoPetrobras.getDataVencimento());
        Log.d("Investimento", "Ação - Taxa Retorno: " + acaoPetrobras.getTaxaRetorno());
        Log.d("Investimento", "Ação - Risco: " + acaoPetrobras.getRisco());
        Log.d("Investimento", "Ação - Tipo: " + acaoPetrobras.getTipoInvestimento());

        Log.d("Investimento", "Título - Nome: " + tesouroSelic.getNome());
        Log.d("Investimento", "Título - Valor Inicial: " + tesouroSelic.getValorInicial());
        Log.d("Investimento", "Título - Data Início: " + tesouroSelic.getDataInicio());
        Log.d("Investimento", "Título - Data Vencimento: " + tesouroSelic.getDataVencimento());
        Log.d("Investimento", "Título - Taxa Retorno: " + tesouroSelic.getTaxaRetorno());
        Log.d("Investimento", "Título - Risco: " + tesouroSelic.getRisco());
        Log.d("Investimento", "Título - Tipo: " + tesouroSelic.getTipoInvestimento());

        Log.d("Investimento", "Fundo - Nome: " + fundoRendaFixa.getNome());
        Log.d("Investimento", "Fundo - Valor Inicial: " + fundoRendaFixa.getValorInicial());
        Log.d("Investimento", "Fundo - Data Início: " + fundoRendaFixa.getDataInicio());
        Log.d("Investimento", "Fundo - Data Vencimento: " + fundoRendaFixa.getDataVencimento());
        Log.d("Investimento", "Fundo - Taxa Retorno: " + fundoRendaFixa.getTaxaRetorno());
        Log.d("Investimento", "Fundo - Risco: " + fundoRendaFixa.getRisco());
        Log.d("Investimento", "Fundo - Tipo: " + fundoRendaFixa.getTipoInvestimento());

        Log.d("Acoes", acaoPetrobras.getNome() + " - Valor Atual: " + acaoPetrobras.getValorAtual());
        Log.d("Acoes", acaoPetrobras.getNome() + " - Rendimento: " + acaoPetrobras.calcularRendimento());

        Log.d("Titulos", tesouroSelic.getNome() + " - Taxa de Juros: " + tesouroSelic.getTaxaJuros());
        Log.d("Titulos", tesouroSelic.getNome() + " - Rendimento Periódico: " + tesouroSelic.calcularRendimento());
        Log.d("Titulos", tesouroSelic.getNome() + " - Rendimento Final Estimado: " + tesouroSelic.calcularRedimentoFinal());

        Log.d("Fundos", fundoRendaFixa.getNome() + " - Taxa de Administração: " + fundoRendaFixa.getTaxaAdministracao());
        Log.d("Fundos", fundoRendaFixa.getNome() + " - Rendimento Estimado: " + fundoRendaFixa.calcularRendimento());
    }
}