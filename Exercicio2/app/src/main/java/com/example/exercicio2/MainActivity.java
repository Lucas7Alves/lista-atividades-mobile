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

        meuDesktop.ligarDesktop();
        meuDesktop.abrirNavegador();
        meuDesktop.varreduraAntiVirus();
        meuDesktop.finalizarVarredura();
        meuDesktop.fecharNavegador();

        try {
            meuDesktop.BluetoothConnect(foneBluetooth);
        } catch (Exception e) {
            Log.i("Bluetooth", "Erro ao conectar: " + e.getMessage());
        }

        Log.i("MobilePhone", meuCelular.ligar("11999999999"));
        Log.i("MobilePhone", meuCelular.tirarFoto());
        Log.i("MobilePhone", meuCelular.enviarSms("11999999999", "Oi, tudo bem?"));

        meuCelular.charge();

        try {
            meuCelular.BluetoothConnect(foneBluetooth);
        } catch (Exception e) {
            Log.i("BluetoothConnect", "Erro ao conectar: " + e.getMessage());
        }
    }
}
