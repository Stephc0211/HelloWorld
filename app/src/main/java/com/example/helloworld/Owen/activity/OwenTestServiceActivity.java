package com.example.helloworld.Owen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.Owen.OwenTestService;
import com.example.helloworld.R;

public class OwenTestServiceActivity extends AppCompatActivity {


    private Button mBtnStartService;
    private Button mBtnStopService;
    private Button mBtnBindService;
    private Button mBtnUnbindService;

    private OwenTestService.MyBinder myBinder;
    private ServiceConnection serviceConnection;


    private static final String TAG = "OwenTestServiceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owen_test_service);


        mBtnStartService = findViewById(R.id.btn_start_service);
        mBtnStopService = findViewById(R.id.btn_stop_service);
        mBtnBindService = findViewById(R.id.btn_bind_service);
        mBtnUnbindService = findViewById(R.id.btn_unbind_service);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d(TAG, "onServiceConnected: ");
                myBinder = (OwenTestService.MyBinder)iBinder;
                myBinder.showLog();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d(TAG, "onServiceDisconnected: ");
            }
        };

        mBtnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwenTestServiceActivity.this, OwenTestService.class);
                startService(intent);
            }
        });

        mBtnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwenTestServiceActivity.this,OwenTestService.class);
                stopService(intent);
            }
        });

        mBtnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwenTestServiceActivity.this,OwenTestService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });

        mBtnUnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(serviceConnection);
            }
        });

    }
}
