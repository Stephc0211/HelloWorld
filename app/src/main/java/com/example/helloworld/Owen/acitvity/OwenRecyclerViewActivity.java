package com.example.helloworld.Owen.acitvity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloworld.Owen.adater.MyRecyclerViewAdapter;
import com.example.helloworld.Owen.bean.Fruit;
import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class OwenRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
   private List<Fruit> mFruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owen_recycler_view);

        mRecyclerView = findViewById(R.id.rv_my_recycler_view);

        for (int i = 0; i < 20; i++){
            Fruit fruit = new Fruit();
            fruit.setFruitImageUrl(R.mipmap.ic_launcher);
            fruit.setFruitName("Stephanie_" + i);
            mFruitList.add(fruit);
        }

        myRecyclerViewAdapter = new MyRecyclerViewAdapter(OwenRecyclerViewActivity.this,
                R.layout.item_owen_my_recycler_view, mFruitList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OwenRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(myRecyclerViewAdapter);

    }
}
