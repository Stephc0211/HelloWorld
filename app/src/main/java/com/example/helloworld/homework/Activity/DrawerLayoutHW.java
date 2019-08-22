package com.example.helloworld.homework.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.helloworld.R;

public class DrawerLayoutHW extends AppCompatActivity {

    private TextView mTvMainMenu;
    private TextView mTvDrawer;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_hw);

        mDrawerLayout = findViewById(R.id.dw_main);

        mTvMainMenu = findViewById(R.id.tv_main_menu);
        mTvMainMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (null != mDrawerLayout){
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        mTvDrawer = findViewById(R.id.tv_drawer);
        mTvDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(null != mDrawerLayout){
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
            }
        });

    }

    @Override
    public void onBackPressed(){
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
