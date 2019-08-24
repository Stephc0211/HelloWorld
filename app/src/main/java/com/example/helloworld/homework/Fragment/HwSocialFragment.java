package com.example.helloworld.homework.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.helloworld.Owen.adater.MyListViewAdapter;
import com.example.helloworld.Owen.bean.Fruit;
import com.example.helloworld.R;
import com.example.helloworld.homework.Activity.FragmentListViewActivity;
import com.example.helloworld.homework.Activity.HWFragementActivity;
import com.example.helloworld.homework.adapter.ListViewAdapterHW;

import java.util.ArrayList;
import java.util.List;

public class HwSocialFragment extends Fragment {

    private ListView mLvFragment;
    private MyListViewAdapter mListViewAdapterHw;
    private List<Fruit> mFruitList = new ArrayList<>();


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
            Fruit fruit = new Fruit();
            fruit.setFruitImageUrl(R.mipmap.ic_launcher);
            fruit.setFruitName("Stephanie_" + i);
            mFruitList.add(fruit);

        }

        mListViewAdapterHw = new MyListViewAdapter(getActivity(), R.layout.item_social_fragment, mFruitList);
        mLvFragment.setAdapter(mListViewAdapterHw);


    }

}
