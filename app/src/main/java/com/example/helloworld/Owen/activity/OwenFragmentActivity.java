package com.example.helloworld.Owen.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.helloworld.Owen.Fragment.OwenSettingFragment;
import com.example.helloworld.Owen.Fragment.OwenWorkFragment;
import com.example.helloworld.R;

public class OwenFragmentActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    private FrameLayout mFlMainContainer;
    private OwenWorkFragment mWorkFragment;
    private OwenSettingFragment mSettingFragment;

    private RadioGroup mRgMain;
    private RadioButton mRbWork;
    private RadioButton mRbSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owen_fragment);

        mFlMainContainer = findViewById(R.id.fl_main_container);
        mRgMain = findViewById(R.id.rg_main);
        mRbWork = findViewById(R.id.rb_work);
        mRbSetting = findViewById(R.id.rb_setting);

        mWorkFragment = new OwenWorkFragment();
        mSettingFragment = new OwenSettingFragment();

        mRgMain.setOnCheckedChangeListener(this);

        mRbWork.setChecked(true);
        replaceFragment(mWorkFragment);
    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main_container,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.rb_work:
                if (null != mWorkFragment){
                    mWorkFragment = new OwenWorkFragment();
                }
                replaceFragment(mWorkFragment);
                break;

            case R.id.rb_setting:
                if (null != mSettingFragment){
                    mSettingFragment = new OwenSettingFragment();
                }
                replaceFragment(mSettingFragment);
                break;

            default:
                break;
        }
    }
}
