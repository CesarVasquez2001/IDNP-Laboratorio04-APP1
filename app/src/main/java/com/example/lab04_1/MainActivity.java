package com.example.lab04_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyBroadcastReceiver objReceiver = new MyBroadcastReceiver();
    @Override
    protected void onStart(){
        super.onStart();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        IntentFilter i = new IntentFilter("app1.mensaje");
        IntentFilter filterApp2 = new IntentFilter("app2.mensaje");
        registerReceiver(objReceiver, filter);
        registerReceiver(objReceiver, i);
        registerReceiver(objReceiver, filterApp2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText textMensaje = findViewById(R.id.edtMessage);
        Button buttonSend = findViewById(R.id.btSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msj = textMensaje.getText().toString();

                Intent intent = new Intent("app1.mensaje");
                intent.putExtra("receiver", msj);
                sendBroadcast(intent);
            }
        });
    }
}