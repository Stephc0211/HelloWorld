package com.example.helloworld.Owen.adater;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.Owen.bean.Fruit;
import com.example.helloworld.R;

import java.util.List;
import java.util.zip.Inflater;

public class MyListViewAdapter extends ArrayAdapter<Fruit> {

    private Context mContext;
    private int mResourceId;
    private List<Fruit> mFruitList;

    /**
     * 构造器
     * @param context
     * @param resource
     */
    public MyListViewAdapter(Context context, int resource , List<Fruit> fruitList) {
        super(context, resource, fruitList);
        this.mContext = context;
        this.mResourceId = resource;
        this.mFruitList = fruitList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Fruit fruit = getItem(position);

        View view = null;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(mResourceId, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.mIvFruit = (ImageView) view.findViewById(R.id.iv_fruit_image);
            viewHolder.mTvFruit = (TextView) view.findViewById(R.id.tv_fruit_name);
            viewHolder.mBtnFruit = (Button) view.findViewById(R.id.btn_fruit_for_click);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (null != fruit) {
            viewHolder.mIvFruit.setImageResource(fruit.getFruitImageUrl());
            viewHolder.mTvFruit.setText(fruit.getFruitName());
            viewHolder.mBtnFruit.setText(fruit.getFruitName());

            viewHolder.mBtnFruit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"you click button " + position + " " + fruit.getFruitName() , Toast.LENGTH_SHORT).show();
                }
            });
        }

        return view;
    }


    class ViewHolder{

        ImageView mIvFruit;
        TextView mTvFruit;
        Button mBtnFruit;

    }

    @Override
    public int getCount() {
        return mFruitList.isEmpty() ? 0 : mFruitList.size();
    }

    @Override
    public Fruit getItem(int position) {
        return mFruitList.isEmpty() ? null : mFruitList.get(position);
    }
}
