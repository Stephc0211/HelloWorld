package com.example.helloworld.homework.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.R;
import com.example.helloworld.homework.Activity.FragmentListViewActivity;
import com.example.helloworld.homework.Activity.SpeechBubbleActivity;
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
            viewHolder.mBtnMyItem = (LinearLayout) view.findViewById(R.id.item_social_fragment);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (null != item) {
            viewHolder.mIvMyItem.setImageResource(item.getProfilePicUrl());
            viewHolder.mTvMyItem.setText(item.getUserName());
            //viewHolder.mBtnMyItem.setText(item.getUserName());

            viewHolder.mBtnMyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, SpeechBubbleActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }

        return view;
    }

    class ViewHolder{

        ImageView mIvMyItem;
        TextView mTvMyItem;
        LinearLayout mBtnMyItem;
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
