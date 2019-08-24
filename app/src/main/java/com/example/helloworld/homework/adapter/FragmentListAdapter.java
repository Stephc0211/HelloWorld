package com.example.helloworld.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.Owen.adater.MyListViewAdapter;
import com.example.helloworld.R;
import com.example.helloworld.homework.bean.MyItem;

import java.util.List;

public class FragmentListAdapter extends ArrayAdapter<MyItem> {

    private Context mContext;
    private int mResourceId;
    private List<MyItem> mItemList;

    public FragmentListAdapter(Context context, int resouce, List<MyItem> itemList){
        super(context, resouce, itemList);
        this.mContext = context;
        this.mItemList = itemList;
        this.mResourceId = resouce;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final MyItem item = getItem(position);

        View view = null;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(mResourceId, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.mIvMyItem = (ImageView) view.findViewById(R.id.iv_fragment_item);
            viewHolder.mTvMyItem = (TextView) view.findViewById(R.id.tv_fragment_item);
            viewHolder.mBtnMyItem = (Button) view.findViewById(R.id.btn_fragment_item);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (null != item) {
            viewHolder.mIvMyItem.setImageResource(item.getProfilePicUrl());
            viewHolder.mTvMyItem.setText(item.getUserName());
            viewHolder.mBtnMyItem.setText(item.getUserName());

            viewHolder.mBtnMyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"you click button " + position + " " + item.getUserName() , Toast.LENGTH_SHORT).show();
                }
            });
        }

        return view;
    }

    class ViewHolder{

        ImageView mIvMyItem;
        TextView mTvMyItem;
        Button mBtnMyItem;
    }

    @Override
    public int getCount() {
        return mItemList.isEmpty() ? 0 : mItemList.size();
    }

    @Override
    public MyItem getItem(int position) {
        return mItemList.isEmpty() ? null : mItemList.get(position);
    }
}
