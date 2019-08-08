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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final String  KEY_USER_NAME = "mUserName";

    private TextView mTvUserName;
    private Button mBtnLogout;

    private String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intentBack = new Intent();
                intentBack.putExtra(KEY_USER_NAME,mUserName);
                setResult(RESULT_OK,intentBack);
                finish();
            }
        });

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
