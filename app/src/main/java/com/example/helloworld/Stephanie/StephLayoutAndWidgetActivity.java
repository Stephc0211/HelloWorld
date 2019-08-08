package com.example.helloworld.Stephanie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.helloworld.R;

public class StephLayoutAndWidgetActivity extends AppCompatActivity {

    private static final String TAG = "StephLayoutAndWidgetAct";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steph_layout_and_widget);
        Log.d(TAG, "onCreate: " + TAG);
    }
}
