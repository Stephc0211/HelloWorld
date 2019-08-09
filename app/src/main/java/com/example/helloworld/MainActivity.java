package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.Stephanie.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LogMainActivity";

    public static final String  KEY_USER_NAME = "mUserName";

    private TextView mTvUserName;
    private Button mBtnLogout;

    private String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: " + TAG);
        mTvUserName = findViewById(R.id.tv_user_name);
        mBtnLogout = findViewById(R.id.btn_logout);

        Intent intent = getIntent();
        mUserName = intent.getStringExtra(KEY_USER_NAME);


        mTvUserName.setText(mUserName);

        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserName = mTvUserName.getText().toString().trim();
                Log.d(TAG,"onClick: " + mUserName);
//                Intent intentBack = new Intent();
//                intentBack.putExtra(KEY_USER_NAME,mUserName);
//                setResult(RESULT_OK,intentBack);
//                finish();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: " + TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + TAG);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + TAG);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: " + TAG);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: " + TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + TAG);
    }

    /**
     * 统一的启动方法
     */
    public static void start(Context context, String mUserName, int mPassword){

        Intent intent = new Intent(context,MainActivity.class);
        intent.putExtra(KEY_USER_NAME,mUserName);
        intent.putExtra("mPassword",mPassword);
        context.startActivity(intent);
    }

}
