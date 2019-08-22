package com.example.helloworld.Owen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.helloworld.R;

public class OwenDrawerLayoutActivity extends AppCompatActivity {

    private TextView mTvOpenDrawer;
    private TextView mTvCloseDrawer;

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owen_drawer_layout);

        // NavigationView 
        mDrawerLayout = findViewById(R.id.dw_main);

        mTvOpenDrawer = findViewById(R.id.tv_open_drawer);
        mTvOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mDrawerLayout){
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        mTvCloseDrawer = findViewById(R.id.tv_close_drawer);
        mTvCloseDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mDrawerLayout){
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
            }
        });



    }
}
