package com.example.lab04_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.Layout;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("app1.mensaje")){
            Log.i("INFO", intent.getStringExtra("receiver") );
            Toast.makeText(context, intent.getStringExtra("receiver"), Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals("app2.mensaje")){
            Log.i("INFO", intent.getStringExtra("receiver") );
            Toast.makeText(context, intent.getStringExtra("receiver"), Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
            if (isAirplaneModeOn(context.getApplicationContext())) {
                Toast.makeText(context, "AirPlane mode on", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "AirPlane mode off", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}