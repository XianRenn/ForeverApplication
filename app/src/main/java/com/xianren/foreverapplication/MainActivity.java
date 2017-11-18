package com.xianren.foreverapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("push", "[ExampleApplication] onCreate");
    }

    public void startBuis(View v) {
//        Intent intent = new Intent();
//        final Intent intent = new Intent(this, ForeverServerice.class);
//        intent.setAction("com.xianren.ForeverServerice");
        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
//        startService(intent);

        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        //创建Intent
        Intent intent = new Intent(this, PushReciver.class);
        intent.setAction("com.example.clock");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        //周期触发
        manager.setRepeating(AlarmManager.RTC, 0, 2 * 1000, pendingIntent);
    }

    public void stopBuis(View v) {
//        Intent intent = new Intent();
//        intent.setAction("com.xianren.ForeverServerice");
        final Intent intent = new Intent(this, ForeverServerice.class);
        stopService(intent);

    }
}
