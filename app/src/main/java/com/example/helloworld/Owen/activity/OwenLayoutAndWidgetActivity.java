package com.example.helloworld.Owen.activity;

import androidx.appcompat.app.AppCompatActivity;;
import android.os.Bundle;
import android.widget.EditText;

import com.example.helloworld.R;

public class OwenLayoutAndWidgetActivity extends AppCompatActivity {

    private EditText mEtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owen_layout_and_widget);
        mEtTest = findViewById(R.id.et_test);


    }
}
