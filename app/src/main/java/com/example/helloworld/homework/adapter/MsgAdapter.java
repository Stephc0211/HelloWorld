package com.example.helloworld.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.homework.Msg;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;
    private Context mContext;

    static class ViewHolder extends  RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;

        TextView leftMsg;

        TextView rightMsg;

        private ViewHolder(View view){
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            leftMsg = (TextView) view.findViewById(R.id.left_msg);
            rightMsg = (TextView) view.findViewById(R.id.right_msg);
        }
    }

    public MsgAdapter(List<Msg>msgList,Context context){
        mMsgList = msgList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Msg msg = mMsgList.get(position);

        if(msg.getType() == Msg.TYPE_RECEIVED) {

            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());

        } else if(msg.getType() == Msg.TYPE_SENT){

            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());

        }

        holder.leftLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"哈哈哈哈哈@Stephanie",Toast.LENGTH_SHORT).show();
            }
        });


    }

        @Override
    public int getItemCount(){
        return mMsgList.size();
        }
}

