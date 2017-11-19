package com.example.jingdong.model;

import com.example.jingdong.api.HomeAPT;
import com.example.jingdong.bean.RegBean;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李倩 on 2017/11/17.
 */

public class Regmodel implements IRegmodel{

    @Override
    public void showReg(HashMap<String, String> map, final Reg reg) {
        HomeAPT.RETRO_API.getreg(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RegBean regBean) {
                        reg.complet(regBean);
                    }
                });
    }
}
