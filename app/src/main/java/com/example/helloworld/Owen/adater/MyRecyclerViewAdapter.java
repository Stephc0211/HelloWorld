package com.example.helloworld.Owen.adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.Owen.bean.Fruit;
import com.example.helloworld.R;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {


    private Context mContext;
    private int mResourceId;
    private List<Fruit> mFruitList;

    public MyRecyclerViewAdapter(Context context, int resource , List<Fruit> fruitList){
        this.mContext = context;
        this.mResourceId = resource;
        this.mFruitList = fruitList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResourceId,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Fruit fruit = mFruitList.get(position);
        holder.mIvFruit.setImageResource(fruit.getFruitImageUrl());
        holder.mTvFruit.setText(fruit.getFruitName());
        holder.mBtnFruit.setText(fruit.getFruitName());

        holder.mBtnFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"you click button " + fruit.getFruitName() , Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"you click item " + fruit.getFruitName() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFruitList.isEmpty() ? 0 : mFruitList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mIvFruit;
        TextView mTvFruit;
        Button mBtnFruit;
        View itemView;

        public ViewHolder(View view){
            super(view);
            this.itemView = view;
            mIvFruit = (ImageView) view.findViewById(R.id.iv_fruit_image_rv);
            mTvFruit = (TextView) view.findViewById(R.id.tv_fruit_name_rv);
            mBtnFruit = (Button) view.findViewById(R.id.btn_fruit_for_click_rv);
        }

    }

}
