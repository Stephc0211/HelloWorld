package com.example.helloworld.homework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.homework.bean.Fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder (View view){
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);

        }
    }

    public FruitAdapter(List<Fruit>fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getFruitImageUrl());
        holder.fruitName.setText(fruit.getFruitName());
    }

    @Override
    public int getItemCount(){
        return mFruitList.size();
    }
}
