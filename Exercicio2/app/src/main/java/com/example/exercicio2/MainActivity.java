package com.example.exercicio2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercicio2.abstracts.Desktop;
import com.example.exercicio2.abstracts.Mobile;
import com.example.exercicio2.entities.Device;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Desktop meuDesktop = new Desktop("Windows", "Dell", "XPS", true);
        Mobile meuCelular = new Mobile("Android", "Samsung", "Galaxy S24", 100.0);
        Device foneBluetooth = new Device("Fone de ouvido", "JBL", "Tune 500");

        try {
            meuDesktop.ligarDesktop();
            meuDesktop.abrirNavegador();
            meuDesktop.varreduraAntiVirus();
            meuDesktop.finalizarVarredura();
            meuDesktop.fecharNavegador();
        } catch (Exception e) {
            Log.e("Desktop", "Erro ao executar operações no Desktop: " + e.getMessage());
        }

        try {
            meuDesktop.BluetoothConnect(foneBluetooth);
        } catch (Exception e) {
            Log.e("Bluetooth", "Erro ao conectar: " + e.getMessage());
        }

        try {
            Log.i("MobilePhone", meuCelular.ligar("11999999999"));
            Log.i("MobilePhone", meuCelular.tirarFoto());
            Log.i("MobilePhone", meuCelular.enviarSms("11999999999", "Oi, tudo bem?"));
        } catch (Exception e) {
            Log.e("MobilePhone", "Erro ao executar função do celular: " + e.getMessage());
        }

        try {
            meuCelular.charge();
        } catch (Exception e) {
            Log.e("MobilePhone", "Erro ao carregar o celular: " + e.getMessage());
        }

        try {
            meuCelular.BluetoothConnect(foneBluetooth);
        } catch (Exception e) {
            Log.e("BluetoothConnect", "Erro ao conectar: " + e.getMessage());
        }
    }
}