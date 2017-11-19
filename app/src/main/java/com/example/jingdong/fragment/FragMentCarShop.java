package com.example.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jingdong.BaseFragment;
import com.example.jingdong.R;
import com.example.jingdong.adapter.CarAdapter;
import com.example.jingdong.bean.CarBean;
import com.example.jingdong.presenter.Carpresenter;
import com.example.jingdong.view.ICarview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by 李倩 on 2017/11/14.
 */

public class FragMentCarShop extends BaseFragment<Carpresenter> implements ICarview {

    @BindView(R.id.car_rv)
    RecyclerView carRv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_carshop, null);
        presenter.showCAR();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void showcar(CarBean carBean) {
        LinearLayoutManager mar=new LinearLayoutManager(getActivity());
        carRv.setLayoutManager(mar);
        CarAdapter adapter=new CarAdapter(getActivity(),carBean);
        carRv.setAdapter(adapter);


    }

    @Override
    public void createpresenter() {
        presenter = new Carpresenter(this, getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
