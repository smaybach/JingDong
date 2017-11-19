package com.example.jingdong.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jingdong.R;
import com.example.jingdong.bean.ZanBean;
import com.example.jingdong.view.ZanView;


/**
 * Created by 李倩 on 2017/11/14.
 */

public class FragMentFaxian extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragment_faxian,null);
        final ZanView zan = (ZanView)view.findViewById(R.id.zv);
        zan.start();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZanBean zanBean = new ZanBean(BitmapFactory.decodeResource(getResources(), R.drawable.love_049), zan);
                zan.addZanXin(zanBean);
            }
        });
        return view;
    }
}
