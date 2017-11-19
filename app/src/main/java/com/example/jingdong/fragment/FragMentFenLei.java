package com.example.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jingdong.BaseFragment;
import com.example.jingdong.R;
import com.example.jingdong.adapter.Fen_lv_lf;
import com.example.jingdong.adapter.Lv_RT_Topadapter;
import com.example.jingdong.bean.Fen_leiBean;
import com.example.jingdong.bean.FenleiBean;
import com.example.jingdong.presenter.Fenleipresenter;
import com.example.jingdong.view.FenleiView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by 李倩 on 2017/11/14.
 */

public class FragMentFenLei extends BaseFragment<Fenleipresenter> implements FenleiView{
    @BindView(R.id.lv_left)
    ListView lvLeft;
    @BindView(R.id.lv_right)
    ListView lvRight;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_fenlei, null);
        unbinder = ButterKnife.bind(this, view);
        presenter.lv_lf();
//        presenter.shoufen(1+"");
        return view;
    }

    @Override
    public void createpresenter() {
        presenter=new Fenleipresenter(this);

    }
    @Override
    public void initData(final FenleiBean fenleiBean) {
        Fen_lv_lf adapter=new Fen_lv_lf(getActivity(),fenleiBean);
        lvLeft.setAdapter(adapter);
        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              presenter.showright(fenleiBean.getData().get(i).getCid()+"");
            }
        });
    }

    @Override
    public void showRight(List<Fen_leiBean.DataBean> list) {
        Lv_RT_Topadapter adapter=new Lv_RT_Topadapter(getActivity(),list);
        lvRight.setAdapter(adapter);
    }

//    @Override
//    public int cid() {
//        return 0;
//    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
