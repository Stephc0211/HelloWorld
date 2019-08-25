package com.example.helloworld.homework.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.helloworld.R;
import com.example.helloworld.homework.Fragment.HwSafariFragment;
import com.example.helloworld.homework.Fragment.HwSettingsFragment;
import com.example.helloworld.homework.Fragment.HwSocialFragment;
import com.example.helloworld.homework.Fragment.HwUserFragment;

public class HWFragementActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private FrameLayout mFlMainContainer;
    private HwSafariFragment mSafariFragment;
    private HwSocialFragment mSocialFragment;
    private HwSettingsFragment mSettingsFragment;
    private HwUserFragment mUserFragment;

    private RadioGroup mRgMain;
    private RadioButton mRgSafari;
    private RadioButton mRgUser;
    private RadioButton mRgSettings;
    private RadioButton mRgSocial;


    @Override
    protected  void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw_fragment);

        mFlMainContainer = findViewById(R.id.fl_main_container_hw);
        mRgMain = findViewById(R.id.rg_main);
        mRgSafari = findViewById(R.id.rb_safari);
        mRgSettings = findViewById(R.id.rb_setting_hw);
        mRgSocial = findViewById(R.id.rb_chat);
        mRgUser = findViewById(R.id.rb_user);

        mSafariFragment = new HwSafariFragment();
        mUserFragment = new HwUserFragment();
        mSocialFragment = new HwSocialFragment();
        mSettingsFragment = new HwSettingsFragment();

        mRgMain.setOnCheckedChangeListener(this);

        mRgUser.setChecked(true);
        replaceFragment(mUserFragment);


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main_container_hw, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch(i) {
            case R.id.rb_chat:
                if (null != mSocialFragment){
                    mSocialFragment = new HwSocialFragment();
                }
                replaceFragment(mSocialFragment);
                break;

            case R.id.rb_setting_hw:
                if (null != mSettingsFragment){
                    mSettingsFragment = new HwSettingsFragment();
                }
                replaceFragment(mSettingsFragment);
                break;

            case R.id.rb_user:
                if (null != mUserFragment){
                    mUserFragment = new HwUserFragment();
                }
                replaceFragment(mUserFragment);
                break;

            case R.id.rb_safari:
                if (null != mSafariFragment){
                    mSafariFragment = new HwSafariFragment();
                }
                replaceFragment(mSafariFragment);
                break;

            default:
                break;

        }
    }
}

