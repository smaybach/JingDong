package com.example.jingdong;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.jingdong.presenter.Ipresenter;


/**
 * Created by 李倩 on 2017/11/14.
 */

public abstract class BaseFragment<T extends Ipresenter> extends Fragment{
   public T presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createpresenter();
    }
    public abstract  void createpresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detch();
        }
    }
}
