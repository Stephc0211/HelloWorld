package com.example.helloworld.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.helloworld.R;
import com.example.helloworld.homework.ListActivityHW;
import com.example.helloworld.homework.bean.Fruit;

import java.util.List;

public class ListViewAdapterHW extends ArrayAdapter<Fruit> {

    private Context mContext;
    private int mResourceId;
    private List<Fruit> mFruitList;

    /**
     * adapter
     * @param context
     * @param resource
     * @param fruitList
     */

    public ListViewAdapterHW(Context context, int resource, List<Fruit>fruitList) {
        super(context, resource,fruitList);
        this.mContext = context;
        this.mFruitList = fruitList;
        this.mResourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        view = LayoutInflater.from(mContext).inflate(mResourceId,parent,false);

        ImageView mIvFruit = (ImageView)view.findViewById(R.id.iv_back);
        TextView mTvFruit = (TextView) view.findViewById(R.id.tv_back);

        mIvFruit.setImageResource(mFruitList.get(position).getFruitImageUrl());
        mTvFruit.setText(mFruitList.get(position).getFruitName());

        return view;
    }

    @Override
    public int getCount(){
        return mFruitList.isEmpty()? 0 : mFruitList.size();
    }
    @Override
    public Fruit getItem(int position){

        return mFruitList.isEmpty()? null : mFruitList.get(position);
    }
}

