package com.example.helloworld.homework.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloworld.Owen.acitvity.OwenRecyclerViewActivity;
import com.example.helloworld.Owen.adater.MyRecyclerViewAdapter;
import com.example.helloworld.R;
import com.example.helloworld.homework.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewHW extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private List<Fruit> mFruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);

        mRecyclerView = findViewById(R.id.hw_recycler_view);

        for(int i = 0; i<20; i++){
            Fruit fruit = new Fruit("apple",R.drawable.front1);
            fruit.setFruitImageUrl(R.drawable.front1);
            fruit.setFruitName("Doll_" + i);
            mFruitList.add(fruit);
        }
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(RecyclerViewHW.this,
                R.layout.item_owen_my_recycler_view, mFruitList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerViewHW.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(myRecyclerViewAdapter);

    }
}
