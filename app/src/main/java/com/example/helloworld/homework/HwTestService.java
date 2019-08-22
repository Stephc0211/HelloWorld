package com.example.helloworld.homework;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class HwTestService extends Service {

    private static final String TAG = "OwenTestService";

    private  MyBinder myBinder = new MyBinder();

    public HwTestService() {
    }

    public class MyBinder extends Binder{
        public void showLog() {
            Log.d(TAG,"showLog: ");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG, "onBind:");
     //   throw new UnsupportedOperationException("Not yet implemented");

        return myBinder;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate:");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand:");
        stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind:");
        return super.onUnbind(intent);
    }
}
