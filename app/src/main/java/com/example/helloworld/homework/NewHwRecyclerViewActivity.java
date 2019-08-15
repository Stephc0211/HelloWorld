package com.example.helloworld.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.helloworld.R;
import com.example.helloworld.homework.adapter.FruitAdapter;
import com.example.helloworld.homework.bean.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewHwRecyclerViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_hw_recycler_layout);
        Log.d("NewRecyclerView","");
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.new_hw_recycler_view);
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

        private void initFruits(){
            for(int i = 0; i < 2; i++){
               Fruit apple = new Fruit(
                       getRandomeLengthName("Apple"), R.drawable.front1);
               fruitList.add(apple);
               Fruit banana = new Fruit(
                       getRandomeLengthName("Banana"), R.drawable.front1);
               fruitList.add(banana);
               Fruit orange = new Fruit(
                       getRandomeLengthName("Orange"), R.drawable.front1);
               fruitList.add(orange);
            }
        }

        private String getRandomeLengthName(String name){
            Random random = new Random();
            int length = random.nextInt(20) + 1;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length; i++){
                builder.append(name);
            }
            return builder.toString();
        }
}
