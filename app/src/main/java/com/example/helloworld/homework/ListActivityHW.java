package com.example.helloworld.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helloworld.R;
import com.example.helloworld.homework.adapter.ListViewAdapterHW;
import com.example.helloworld.homework.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class ListActivityHW extends AppCompatActivity {

    private ListView hwLv;
    //private ArrayAdapter<String> mArrayAdapter;
    //private List<String> mStringList= new ArrayList<>();

    private ListViewAdapterHW listViewAdapterHW;
    private List<Fruit> mFruitList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_ac_hw);
        hwLv = findViewById(R.id.hw_lv);

        //for(int i=1; i<=10;i++){
           // mStringList.add("手办 " + i);}

        //mArrayAdapter = new ArrayAdapter<>(ListActivityHW.this,
               // android.R.layout.simple_list_item_1,mStringList);
        //hwLv.setAdapter(mArrayAdapter);

        for(int i = 1; i<=20; i++){
            Fruit fruit = new Fruit("apple",R.id.iv_front);
            fruit.setFruitImageUrl(R.drawable.back1);
            fruit.setFruitName("后面");
            mFruitList.add(fruit);
        }

        listViewAdapterHW = new ListViewAdapterHW(ListActivityHW.this,R.layout.item_my_list_view,mFruitList);
        hwLv.setAdapter(listViewAdapterHW);

        hwLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(ListActivityHW.this,"you click item"+ i +" "+mStringList.get(i),
                        //Toast.LENGTH_SHORT).show();
                Toast.makeText(ListActivityHW.this,"you click item" + i + " " + mFruitList.get(i),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
