package com.example.helloworld.Stephanie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class LoginActivity extends AppCompatActivity {

    private Button mBtnRegister;
    private TextView mTvLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mBtnRegister = findViewById(R.id.btn_register);
        mTvLogin = findViewById(R.id.btn_login);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }

        );


    }
}
