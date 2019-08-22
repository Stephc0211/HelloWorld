package com.example.helloworld.Owen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helloworld.Owen.adater.MyListViewAdapter;
import com.example.helloworld.Owen.bean.Fruit;
import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class OwenListViewActivity extends AppCompatActivity {

    private ListView mLvMyLv;
//    private ArrayAdapter<String> mArrayAdapter;
//    private List<String> mStringList = new ArrayList<>();

    private MyListViewAdapter myListViewAdapter;
    private List<Fruit> mFruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owen_list_view);
        mLvMyLv = findViewById(R.id.lv_my_lv);


//        for (int i = 0; i < 100; i++){
//            mStringList.add("Stephanie_" + i);
//        }
//        mArrayAdapter = new ArrayAdapter<>(OwenListViewActivity.this,android.R.layout.simple_list_item_1,mStringList);
//        mLvMyLv.setAdapter(mArrayAdapter);

        for (int i = 0; i < 20; i++){
            Fruit fruit = new Fruit();
            fruit.setFruitImageUrl(R.mipmap.ic_launcher);
            fruit.setFruitName("Stephanie_" + i);
            mFruitList.add(fruit);
        }

        myListViewAdapter = new MyListViewAdapter(OwenListViewActivity.this, R.layout.item_owen_my_list_view, mFruitList);
        mLvMyLv.setAdapter(myListViewAdapter);

        mLvMyLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              //  Toast.makeText(OwenListViewActivity.this,"you click item " + i + " " + mStringList.get(i) ,Toast.LENGTH_SHORT).show();
                Toast.makeText(OwenListViewActivity.this,"you click item " + i + " " + mFruitList.get(i).getFruitName() ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
