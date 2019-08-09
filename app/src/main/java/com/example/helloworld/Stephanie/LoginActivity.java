package com.example.helloworld.Stephanie;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.MainActivity;
import com.example.helloworld.R;

import static com.example.helloworld.MainActivity.KEY_USER_NAME;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LogLoginActivity";



    public static final int REQUEST_CODE_LOGIN = 100;

    private Button mBtnRegister;
    private TextView mTvLogin;
    private EditText mEtUserName;

    private String mUserName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_login);

        Log.d(TAG, "onCreate: " + TAG);
        mBtnRegister = findViewById(R.id.btn_register);
        mTvLogin = findViewById(R.id.tv_login);
        mEtUserName = findViewById(R.id.et_user_name);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Toast.makeText(LoginActivity.this, "我点击了注册按钮 ",
//                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        });

        mTvLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //关闭Activity
                //finish();
                if(!TextUtils.isEmpty(mEtUserName.getText())) {
                    mUserName = mEtUserName.getText().toString().trim();
                }
                /**跳转到MainActivity
                Intent intent = new Intent (LoginActivity.this,
                        MainActivity.class);
                intent.putExtra("username",mUserName);
                startActivity(intent);

                MainActivity.start(LoginActivity.this,mUserName,0);
                 */

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra(KEY_USER_NAME,mUserName);
                startActivityForResult(intent,REQUEST_CODE_LOGIN );


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_LOGIN){
                String mUserName = data.getStringExtra(KEY_USER_NAME);
                Log.d(TAG,"onActivityResult: " + mUserName);
                Toast.makeText(LoginActivity.this,"我收到了返回值: "
                        + mUserName, Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
