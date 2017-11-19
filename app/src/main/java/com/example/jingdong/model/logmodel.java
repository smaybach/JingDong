package com.example.jingdong.model;

import com.example.jingdong.api.HomeAPT;
import com.example.jingdong.bean.LogBean;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李倩 on 2017/11/17.
 */

public class logmodel implements Ilogmodel{
    @Override
    public void showlog(HashMap<String, String> ma, final Log log) {
        HomeAPT.RETRO_API.getLogin(ma)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LogBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LogBean logBean) {
                        log.complet(logBean);
                    }
                });
    }
}
