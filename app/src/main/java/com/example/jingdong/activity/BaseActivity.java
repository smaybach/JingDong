package com.example.jingdong.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.jingdong.presenter.Ipresenter;


/**
 * Created by 李倩 on 2017/11/15.
 */

public  abstract  class BaseActivity<T extends Ipresenter> extends Activity {
    public  T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createpresenter();
    }
    public  abstract  void createpresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detch();
        }
    }
}
