package com.example.helloworld.homework.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;
import com.example.helloworld.homework.adapter.FragmentListAdapter;
import com.example.helloworld.homework.bean.MyItem;

import java.util.ArrayList;
import java.util.List;

public class FragmentListViewActivity extends AppCompatActivity {

    private ListView mLvMyLv;
//    private ArrayAdapter<String> mArrayAdapter;
//    private List<String> mStringList = new ArrayList<>();

    private FragmentListAdapter fragmentListAdapter;
    private List<MyItem> mItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_hw_social);
        mLvMyLv = findViewById(R.id.hw_fragment_lv);


//        for (int i = 0; i < 100; i++){
//            mStringList.add("Stephanie_" + i);
//        }
//        mArrayAdapter = new ArrayAdapter<>(OwenListViewActivity.this,android.R.layout.simple_list_item_1,mStringList);
//        mLvMyLv.setAdapter(mArrayAdapter);

        for (int i = 0; i < 20; i++){
            MyItem item = new MyItem();
            item.setProfilePicUrl(R.mipmap.ic_launcher);
            item.setUserName("Stephanie_" + i);
            //item.setChatButton(R.id.fragment_list_btn);
            mItemList.add(item);


        }

        fragmentListAdapter = new FragmentListAdapter(FragmentListViewActivity.this, R.layout.item_social_fragment, mItemList);
        mLvMyLv.setAdapter(fragmentListAdapter);

        mLvMyLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              //  Toast.makeText(OwenListViewActivity.this,"you click item " + i + " " + mStringList.get(i) ,Toast.LENGTH_SHORT).show();
                Toast.makeText(FragmentListViewActivity.this,"you click item " + i + " " + mItemList.get(i).getUserName() ,Toast.LENGTH_SHORT).show();
            }
        });

        Button button = (Button) findViewById(R.id.btn_fragment_item);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentListViewActivity.this, SpeechBubbleActivity.class);
                startActivity(intent);
            }
        });

    }
}
