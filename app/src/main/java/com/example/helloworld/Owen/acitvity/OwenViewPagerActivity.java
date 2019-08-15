package com.example.helloworld.Owen.acitvity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class OwenViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<View> viewList = new ArrayList<>();
    private View viewFirst;
    private View viewSecond;
    private View viewThird;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owen_view_pager);


        mViewPager = findViewById(R.id.vp_main);
        LayoutInflater layoutInflater = getLayoutInflater();
        viewFirst =  layoutInflater.inflate(R.layout.view_first,null);
        viewSecond =  layoutInflater.inflate(R.layout.view_second,null);
        viewThird =  layoutInflater.inflate(R.layout.view_third,null);

        viewList.add(viewFirst);
        viewList.add(viewSecond);
        viewList.add(viewThird);

        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.isEmpty() ? 0 : viewList.size();

            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(viewList.get(position));
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(viewList.get(position));

                return viewList.get(position);
            }
        };

        mViewPager.setAdapter(pagerAdapter);



    }
}
