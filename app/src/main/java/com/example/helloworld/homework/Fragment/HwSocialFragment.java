package com.example.helloworld.homework.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.helloworld.Owen.adater.MyListViewAdapter;
import com.example.helloworld.Owen.bean.Fruit;
import com.example.helloworld.R;
import com.example.helloworld.homework.Activity.HWFragementActivity;
import com.example.helloworld.homework.Activity.speech_bubble_activity;
import com.example.helloworld.homework.adapter.FragmentListAdapter;
import com.example.helloworld.homework.bean.MyItem;

import java.util.ArrayList;
import java.util.List;

public class HwSocialFragment extends Fragment {

    private ListView mLvFragment;
    private FragmentListAdapter fragmentListAdapter;
    private List<MyItem> myItemList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hw_social, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLvFragment = getActivity().findViewById(R.id.hw_fragment_lv);

        for (int i = 0; i < 20; i++) {
            MyItem myItem = new MyItem();
            myItem.setProfilePicUrl(R.mipmap.ic_launcher);
            myItem.setUserName("Stephanie_" + i);
            myItemList.add(myItem);

        }

        fragmentListAdapter = new FragmentListAdapter(getActivity(), R.layout.item_social_fragment, myItemList);
        mLvFragment.setAdapter(fragmentListAdapter);

    }

}
